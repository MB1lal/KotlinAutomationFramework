package steps.backend.connectors

import core.EnvSerenity
import io.restassured.http.ContentType
import io.restassured.response.Response
import io.restassured.specification.RequestSpecification
import net.serenitybdd.rest.SerenityRest

class PetStoreConnector {

    private val baseUri = EnvSerenity().basePetStoreUri

    private fun baseRequest(): RequestSpecification = SerenityRest.with()
        .contentType(ContentType.JSON).baseUri(baseUri)

    fun placingAnOrder(body: String) {
        baseRequest()
            .body(body)
            .accept(ContentType.JSON)
            .post("/order")
            .then()
            .statusCode(200)
    }

    fun fetchOrder(orderId: Int): Response = baseRequest()["/order/$orderId"]
        .then()
        .assertThat()
        .statusCode(200)
        .extract().response()

    fun fetchInvalidOrder(orderId: Int) {
        baseRequest()["/order/$orderId"]
            .then()
            .assertThat()
            .statusCode(404)
    }

    fun deleteOrderById(orderId: Int) {
        baseRequest()
            .delete("/order/$orderId")
            .then()
            .assertThat()
            .statusCode(200)
    }

}
