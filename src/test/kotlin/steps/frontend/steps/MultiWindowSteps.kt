package steps.frontend.steps

import steps.core.BaseSteps
import io.cucumber.java.en.And
import io.cucumber.java.en.Then
import io.cucumber.java.en.When

class MultiWindowSteps : BaseSteps() {

    @When("I click the \"Click Here\" link to open a new window")
    fun clickButtonToOpenNewWindow() {
        logger.info("Clicking button to open link in new window")
        TODO()
    }

    @And("I switch to the new window")
    fun switchWindow() {
        logger.info("Switching to the new window")
        TODO()
    }

    @Then("I should perform actions in the new window")
    fun performActionsOnNewWindow() {
        logger.info("Performing actions on newly opened window")
        TODO()
    }

    @And("I should close the new window and switch back to the original window")
    fun verifyingWindowIsClosed() {
        logger.info("Verifying window is closed")
        TODO()
    }


}