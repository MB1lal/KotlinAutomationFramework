package steps.frontend.steps

import steps.core.BaseSteps
import io.cucumber.java.en.And
import io.cucumber.java.en.Then
import io.cucumber.java.en.When

class JSAlertSteps : BaseSteps() {

    @When("I click the {} button of alert")
    fun clickJSAlertButton(buttonText: String) {
        logger.info("Clicking the $buttonText button")
        when(buttonText) {
            "Click for JS Alert" -> TODO()
            "Click for JS Confirm" -> TODO()
            "Click for JS Prompt" -> TODO()
        }
    }

    @And("I should see a JavaScript {} dialog")
    @Then("I should see a JavaScript alert")
    fun verifyJSAlertIsDisplayed(alertType: String = "alert") {
        logger.info("Verifying alert is displayed")
        when(alertType) {
            "alert" -> TODO()
            "confirmation" -> TODO()
            "prompt" -> TODO()
        }
    }

    @And("I interact as {} with the {}")
    fun interactWithAlerts(interaction: String, alertType: String) {
        when(alertType) {
            "alert" -> TODO()
            "confirmation" -> TODO()
            "prompt" -> TODO()
        }
    }

    @And("I enter {} in the prompt")
    fun enterTextIntoPrompt(inputText: String) {
        logger.info("Entering $inputText into the prompt")
        TODO()
    }

}