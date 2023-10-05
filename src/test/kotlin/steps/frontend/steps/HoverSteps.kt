package steps.frontend.steps

import steps.core.BaseSteps
import io.cucumber.java.en.Then
import io.cucumber.java.en.When

class HoverSteps : BaseSteps() {


    @When("I hover over the {} user avatar")
    fun hoverOverXUserAvatar(userIndex: String) {
        logger.info("Hovering over $userIndex user avatar")
        when(userIndex) {
            "first" -> TODO()
            "second" -> TODO()
            "third" -> TODO()
        }
    }

    @Then("I should see user information for the {} user")
    fun verifyInformationForXUser(userIndex: String) {
        logger.info("Verifying the user information for $userIndex user")
        when(userIndex) {
            "first" -> TODO()
            "second" -> TODO()
            "third" -> TODO()
        }
    }

}