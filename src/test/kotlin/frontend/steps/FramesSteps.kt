package frontend.steps

import core.BaseSteps
import io.cucumber.java.en.And
import io.cucumber.java.en.Then
import io.cucumber.java.en.When

class FramesSteps : BaseSteps() {

    @When("I switch to the {} frame")
    fun switchToXFrame(frameIndex: String) {
        logger.info("Switching to $frameIndex frame")
        when(frameIndex) {
            "first" -> TODO()
            "second" -> TODO()
        }
    }

    @And("I interact with elements in the {} frame")
    fun interactWithXFrameElement(frameIndex: String) {
        logger.info("Interacting with $frameIndex elements")
        when(frameIndex) {
            "first" -> TODO()
            "second" -> TODO()
        }
    }

    @Then("I should switch back to the main content")
    fun verifyMainContentIsDisplayed() {
        logger.info("Verifying user is switched to main content")
        TODO()
    }

}