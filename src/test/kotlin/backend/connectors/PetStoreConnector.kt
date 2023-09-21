package backend.connectors

import io.restassured.http.ContentType
import io.restassured.specification.RequestSpecification
import net.serenitybdd.rest.SerenityRest
import org.eclipse.jetty.websocket.api.StatusCode

class PetStoreConnector {

    private fun baseRequest(): RequestSpecification = SerenityRest.with().contentType(ContentType.JSON).baseUri("")

    fun placingAnOrder(body: String) {
        baseRequest()
            .body(body)
            .post("/order")
            .then()
            .statusCode(StatusCode.NORMAL)
    }



}