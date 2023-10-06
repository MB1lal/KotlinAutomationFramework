package steps.frontend

import pages.AuthenticationPage
import io.cucumber.java.en.And
import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import io.cucumber.java.en.When
import org.assertj.core.api.Assertions.assertThat
import steps.base.BaseSteps

class AuthenticationSteps : BaseSteps() {

    var authenticationPage = AuthenticationPage()

    lateinit var herokuMainPageSteps: HerokuMainPageSteps

    @When("I enter username {} and password {}")
    fun enterUserPass(username: String, password: String) {
        logger.info("Entering username and password")
        authenticationPage.enterUsernameAndPassword(username, password)
    }

    @And("I click the login button")
    fun loginIsClicked() {
        logger.info("Logging in")
        authenticationPage.clickLogin()
    }

    @Then("I should be logged in successfully")
    fun userIsLoggedIn() {
        assertThat(authenticationPage.userIsLoggedIn())
            .`as`("User is not logged in.")
            .isTrue()!!
        logger.info("Logged in successfully")
    }

    @Then("I should see an error message {}")
    fun userIsNotLoggedIn(error: String) {
        assertThat(authenticationPage.driver.pageSource).contains(error)!!
        logger.info("Not logged in")
    }

    @Given("I am logged in on the form authentication page")
    fun userIsAlreadyLoggedIn() {
        herokuMainPageSteps = HerokuMainPageSteps()
        herokuMainPageSteps.navigateToXPage("form authentication")
        enterUserPass("tomsmith","SuperSecretPassword!")
        loginIsClicked()
    }

    @When("I click the logout button")
    fun logoutIsClicked() {
        logger.info("User is logging out")
        authenticationPage.clickLogout()
    }

    @Then("I should be logged out and redirected to the login page")
    fun userIsLoggedOut() {
        assertThat(authenticationPage.userIsLoggedOut())
            .`as`("User is not logged out.")
            .isTrue()!!
        logger.info("User is logged out")
        assertThat(authenticationPage.driver.currentUrl)
            .`as`("User is not logged out")
            .contains("/login")
        logger.info("User is at login page")
    }

}