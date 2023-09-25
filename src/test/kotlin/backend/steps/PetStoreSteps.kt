package backend.steps


import backend.models.store.PetStoreModel
import io.cucumber.java.en.And
import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import io.cucumber.java.en.When
import io.restassured.response.Response
import net.serenitybdd.core.Serenity
import org.assertj.core.api.Assertions.assertThat
import utils.SharedStateConstants.BACKEND.PET_STORE.PET_STORE_RESPONSE
import utils.SharedStateConstants.BACKEND.PET_STORE.PET_ORDER_ID


class PetStoreSteps : BaseSteps() {

    @Given("I place an order on pet store with id = {}")
    fun orderIsPlaced(orderId: Int) {
        val petStoreModel = createPetStorePayload()
        petStoreModel.id = orderId
        placePetStoreOrder(petStoreModel = petStoreModel)
    }

    @When("I fetch the order using id = {int}")
    fun petStoreOrderStatusIsCalled(orderId: Int) {
        fetchPetStoreOrderDetails(orderId)
    }

    @Then("The order is successfully placed")
    fun assertingOrderIsSuccessfullyPlaced() {
        val response: Response = Serenity.sessionVariableCalled(PET_STORE_RESPONSE)
        val petStoreModel: PetStoreModel = response.`as`(PetStoreModel::class.java)
        assertThat(petStoreModel.id)
            .withFailMessage("The order Id is not found.")
            .isEqualTo(Serenity.sessionVariableCalled(PET_ORDER_ID))
    }

    @When("I delete the order by id = {int}")
    fun deleteByOrderId(orderId: Int) {
        deleteOrderById(orderId)
    }

    @And("The order with id = {int} shouldn't exist")
    fun assertOrderDoesNotExist(orderId: Int) {
        fetchDeletedOrder(orderId)
    }

}