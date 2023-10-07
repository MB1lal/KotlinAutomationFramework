package steps.backend

import connectors.UserConnector
import models.users.UserModel
import io.cucumber.java.en.And
import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import io.cucumber.java.en.When
import io.restassured.response.Response
import net.serenitybdd.core.Serenity
import org.assertj.core.api.Assertions
import steps.base.BaseSteps
import utils.SharedStateConstants

class UsersSteps : BaseSteps() {
    private val userConnector: UserConnector = UserConnector()
    @Given("I create a user")
    fun i_create_a_user() {
        val user: UserModel = createUserPayLoad()
        userConnector.createNewUser(user.toJson())
    }

    @When("User is successfully created")
    fun user_is_successfully_created() {
        verifyUserExists()
    }

    @Then("I login using same user")
    fun i_login_using_same_user() {
        loginUser()
    }

    @Then("I logout using same user")
    fun i_logout_using_same_user() {
        logoutUser()
    }

    @Then("I delete the user")
    fun i_delete_user() {
        Serenity.setSessionVariable(SharedStateConstants.BACKEND.USERS.USER_RESPONSE)
            .to(userConnector.deleteUser(Serenity.sessionVariableCalled(SharedStateConstants.BACKEND.USERS.USERNAME)))
    }

    @And("User is successfully deleted")
    fun user_is_successfully_deleted() {
        val response: Response = Serenity.sessionVariableCalled<Response>(SharedStateConstants.BACKEND.USERS.USER_RESPONSE)
        Assertions.assertThat(response.statusCode()).isEqualTo(200)
    }
}
