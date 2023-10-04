package frontend.steps

import core.BaseSteps
import frontend.pages.DynamicLoadingExample1Page
import frontend.pages.DynamicLoadingExample2Page
import frontend.pages.DynamicLoadingPage
import io.cucumber.java.en.And
import io.cucumber.java.en.Then
import io.cucumber.java.en.When
import org.assertj.core.api.Assertions.assertThat

class DynamicLoadingSteps : BaseSteps() {

    private var dynamicLoadingPage = DynamicLoadingPage()
    private var dynamicLoadingExample1 = DynamicLoadingExample1Page()
    private var dynamicLoadingExample2 = DynamicLoadingExample2Page()

    private var exampleNumber: Int = 0


    @When("I click the {} link")
    fun navigateToExample(example: String) {
        if(!example.contains("Example 1") && !example.contains("Example 2")) {
            logger.error("Invalid example specified")
            throw IllegalArgumentException("")
        }
        logger.info("Navigating to $example")
        exampleNumber = if(example.contains("1")) 1 else 2
        dynamicLoadingPage.navigateToExample(example)
    }

    @And("I click the \"Start\" button")
    fun clickStart() {
        logger.info("Clicking start button")
       when(exampleNumber) {
           1 -> dynamicLoadingExample1.clickStart()
           2 -> dynamicLoadingExample2.clickStart()
       }
    }

    @Then("I should see the loaded element on the page")
    fun verifyElementIsLoaded() {
        val validationText = "Hello World!"
        when(exampleNumber) {
            1 -> assertThat(dynamicLoadingExample1.getLoadedElementText()).`as`("Incorrect text").isEqualTo(validationText)
            2 -> assertThat(dynamicLoadingExample2.getLoadedElementText()).`as`("Incorrect text").isEqualTo(validationText)
        }
    }

}