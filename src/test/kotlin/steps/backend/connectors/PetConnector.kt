package steps.backend.connectors

import core.EnvSerenity
import io.restassured.http.ContentType
import io.restassured.response.Response
import io.restassured.specification.RequestSpecification
import net.serenitybdd.core.Serenity
import net.serenitybdd.rest.SerenityRest
import utils.SharedStateConstants.BACKEND

class PetConnector {

    private var baseUri = EnvSerenity().basePetUri

    private fun baseRequest(): RequestSpecification {
        return SerenityRest
            .with()
            .contentType(ContentType.JSON)
            .baseUri(baseUri)
    }

    fun addNewPet(body: String?) {
        baseRequest()
            .body(body)
            .post()
            .then()
            .statusCode(200)
            .extract().response()
    }

    fun getPetById(id: Int): Response {
        return baseRequest()["/$id"]
    }

    fun getPetStatus(status: List<String?>?): Response {
        return baseRequest()
            .param("status", status)["/findByStatus"]
            .then()
            .statusCode(200)
            .extract().response()
    }

    fun deletePetWithId(petId: Int) {
        baseRequest()
            .delete("/$petId")
            .then()
            .statusCode(200)
            .extract().response()
    }

    fun updatePetDetails(attribute: String?, attributeValue: String?) {
        baseRequest()
            .header("Content-Type", ContentType.URLENC)
            .formParam(attribute, attributeValue)
            .post("/" + Serenity.sessionVariableCalled(BACKEND.PET_ID))
            .then()
            .statusCode(200)
            .extract().response()
    }
}