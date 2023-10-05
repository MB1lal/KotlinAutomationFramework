package steps.frontend.`step-definitions`

import steps.base.BaseSteps
import steps.frontend.pages.FramesPage
import steps.frontend.pages.IFramePage
import steps.frontend.pages.NestedFramesPage
import io.cucumber.java.en.And
import io.cucumber.java.en.Then
import io.cucumber.java.en.When
import org.assertj.core.api.Assertions.assertThat

class FramesSteps : BaseSteps() {

    val framesPage = FramesPage()
    val iFramePage = IFramePage()
    val nestedFramesPage = NestedFramesPage()

    @When("I navigate to {} page")
    fun navigateToXFramePage(framePage: String) {
        logger.info("Switching to $framePage")
        framesPage.navigateToXFramePage(framePage)
    }

    @And("I write {}in iframe")
    fun inputTextIntoIFrame(inputText: String) {
        logger.info("Switching to iFrame")
        iFramePage.switchToIFrame()
        logger.info("Entering text into iFrame")
        iFramePage.enterTextIntoContent(inputText)
    }

    @Then("iframe has the text {}")
    fun verifyMainContentIsDisplayed(expectedText: String) {
        logger.info("Verifying text of iFrame")
        assertThat(iFramePage.getIFrameText()).`as`("Incorrect text").isEqualTo(expectedText)
    }

    @Then("{} frame has {} text")
    fun verifyFrameTexts(frameIdentifier: String, expectedText: String) {
        logger.info("Verifying $frameIdentifier has $expectedText text")
        assertThat(nestedFramesPage.getFrameText(frameIdentifier)).isEqualTo(expectedText)
    }

}