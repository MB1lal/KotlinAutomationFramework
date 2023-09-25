package backend.steps

import backend.models.pet.PetModel
import io.cucumber.java.en.And
import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import io.cucumber.java.en.When
import io.restassured.response.Response
import net.serenitybdd.core.Serenity
import org.assertj.core.api.Assertions
import utils.SharedStateConstants.BACKEND
import utils.SharedStateConstants.BACKEND.PET
import java.io.IOException
import java.util.*

class PetsSteps : BaseSteps() {
    @Given("I add the pet with {} = {}")
    @Throws(IOException::class)
    fun addAPet(param: String, paramValue: String) {
        val petModel: PetModel = createPetPayloadUsingFile()
        when (param.lowercase(Locale.getDefault())) {
            "id" -> {
                petModel.id = paramValue.toLong()
            }

            "status" -> {
                petModel.status = paramValue
            }
        }
        addANewPet(petModel)
    }

    @And("The pet with id = {int} {}")
    fun assertingPetWithId(petId: Int, result: String?) {
        val response = Serenity.sessionVariableCalled<Response>(PET.PET_RESPONSE)
        when (result) {
            "exists" -> {
                Assertions.assertThat(response.statusCode())
                    .withFailMessage("The pet with id = $petId doesn't exists")
                    .isEqualTo(200)
                val petResponse = response.`as`(PetModel::class.java)
                Assertions.assertThat(petResponse.id)
                    .withFailMessage("No pet with petId = $petId exists.")
                    .isEqualTo(petId.toLong())
            }

            "doesn't exists" -> Assertions.assertThat(response.statusCode())
                .withFailMessage("The pet with id = $petId still exists")
                .isEqualTo(404)
        }
    }

    @When("I call the pet api with {}")
    fun callingApiWithId(callingParameter: String) {
        when (callingParameter.lowercase(Locale.getDefault())) {
            "id" -> getPetById(Serenity.sessionVariableCalled(BACKEND.PET_ID))
            "status" -> getPetStatus(listOf(Serenity.sessionVariableCalled(PET.PET_STATUS)))
        }
    }

    @Then("The pet has status = {}")
    fun assertingPetWithStatus(status: String) {
        val response = Serenity.sessionVariableCalled<Response>(PET.PET_RESPONSE)
        val petModel: PetModel
        petModel = if (response.body.asString().startsWith("{")) {
            response.`as`(PetModel::class.java)
        } else {
            val petResponse = response.`as`(Array<PetModel>::class.java)
            Assertions.assertThat(
                Arrays.stream(petResponse)
                    .anyMatch { pets: PetModel -> pets.id == Serenity.sessionVariableCalled<Any>(BACKEND.PET_ID) as Long })
                .withFailMessage("No pet with id = " + Serenity.sessionVariableCalled(BACKEND.PET_ID) + " exists.")
                .isTrue()
            Arrays.stream(petResponse)
                .filter { pets: PetModel -> pets.id == Serenity.sessionVariableCalled<Any>(BACKEND.PET_ID) as Long }
                .findFirst().get()
        }
        Assertions.assertThat(petModel.status)
            .withFailMessage("No pet with status = $status exists.")
            .isEqualTo(status)
    }

    @When("I call the pet deletion api with id = {int}")
    fun deletingThePetWithId(id: Long) {
        deletePetWithId(id)
    }

    @And("I update the pet {} to {}")
    fun updatingPetDetails(attribute: String?, attributeValue: String?) {
        updatePetDetails(attribute, attributeValue)
    }
}
