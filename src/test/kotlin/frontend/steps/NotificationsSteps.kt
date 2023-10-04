package frontend.steps

import core.BaseSteps
import io.cucumber.java.en.Then
import io.cucumber.java.en.When

class NotificationsSteps : BaseSteps() {


    @When("I click the \"Click here\" link multiple times")
    fun clickButtonMultipleTimes() {
        logger.info("Clicking the notifications button multiple times")
        TODO()
    }

    @Then("I should see different notification messages")
    fun verifyNotificationMessages() {
        logger.info("Verifying notification messages")
        TODO()
    }

}