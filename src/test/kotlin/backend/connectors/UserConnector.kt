package backend.connectors

import core.EnvSerenity
import io.restassured.http.ContentType
import io.restassured.response.Response
import io.restassured.specification.RequestSpecification
import net.serenitybdd.rest.SerenityRest

class UserConnector {
    private var baseUri = EnvSerenity().baseUserUri
    private fun baseRequest(): RequestSpecification {
        return SerenityRest
            .with()
            .contentType(ContentType.JSON)
            .baseUri(baseUri)
    }

    fun getUser(username: String): Response {
        return baseRequest()["/$username"]
            .then()
            .statusCode(200)
            .extract().response()
    }

    fun loginExistingUser(username: String?, password: String?): Response {
        return baseRequest()
            .formParam("username", username)
            .formParam("password", password)["/login"]
            .then()
            .statusCode(200)
            .extract().response()
    }

    fun logoutUser() {
        baseRequest()["/logout"]
            .then()
            .statusCode(200)
    }

    fun createNewUser(user: String?) {
        baseRequest()
            .body(user)
            .post()
            .then()
            .statusCode(200)
    }

    fun deleteUser(username: String): Response {
        return baseRequest()
            .delete("/$username")
    }
}