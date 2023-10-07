package steps.frontend

import io.cucumber.java.en.And
import io.cucumber.java.en.Then
import io.cucumber.java.en.When
import org.assertj.core.api.Assertions
import pages.MultiWindowPage
import steps.base.BaseSteps

class MultiWindowSteps : BaseSteps() {

    private val multiWindowPage = MultiWindowPage()

    @When("I click the \"Click Here\" link to open a new window")
    fun clickButtonToOpenNewWindow() {
        logger.info("Clicking button to open link in new window")
        multiWindowPage.openClickHereLink()
    }

    @And("I switch to the {} tab")
    fun switchWindow(tabId: String) {
        logger.info("Switching to the $tabId tab")
        multiWindowPage.switchToTab(tabId)
    }

    @Then("Header of the page should have {} text")
    fun performActionsOnNewWindow(expectedText: String) {
        logger.info("Asserting header text of page")
        Assertions.assertThat(multiWindowPage.getHeaderText()).`as`("Incorrect text on new tab").isEqualTo(expectedText)
    }

}