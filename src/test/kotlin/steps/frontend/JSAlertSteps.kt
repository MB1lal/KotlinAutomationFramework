package steps.frontend

import io.cucumber.java.en.And
import io.cucumber.java.en.When
import org.assertj.core.api.Assertions.assertThat
import pages.JSAlertPage
import steps.base.BaseSteps

class JSAlertSteps : BaseSteps() {

    private val jsAlertPage = JSAlertPage()

    @When("I click the {} button of alert")
    fun clickJSAlertButton(buttonText: String) {
        logger.info("Clicking the $buttonText button")
        jsAlertPage.triggerJSAlert(buttonText)
    }

    @And("I interact as {} with the {}")
    fun interactWithAlerts(interaction: String, alertType: String) {
        logger.info("Interacting with $alertType as $interaction")
        jsAlertPage.interactWithAlert(interaction)
    }

    @And("I enter {} in the prompt")
    fun enterTextIntoPrompt(inputText: String) {
        logger.info("Entering $inputText into the prompt")
        jsAlertPage.enterTextIntoAlert(inputText)
    }

    @And("Result says {}")
    fun verifyResultText(expectedText: String) {
        logger.info("Verifying result text")
        assertThat(jsAlertPage.getResultText()).isEqualTo(expectedText)
    }

}