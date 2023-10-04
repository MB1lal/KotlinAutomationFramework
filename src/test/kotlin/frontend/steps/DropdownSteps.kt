package frontend.steps

import core.BaseSteps
import frontend.pages.DropdownPage
import io.cucumber.java.en.Then
import io.cucumber.java.en.When
import org.assertj.core.api.Assertions.assertThat

class DropdownSteps : BaseSteps() {

    private var dropdownPage = DropdownPage()

    @When("I select option {} from the dropdown")
    fun selectDropdownOption(option: String) {
        logger.info("Selecting $option from dropdown")
        dropdownPage.selectDropdownOption(option)
    }

    @Then("the selected option should be {}")
    fun verifySelectedOption(option: String) {
        logger.info("Verifying $option from dropdown")
        assertThat(dropdownPage.getDropdownSelectedOption())
            .`as`("Selected option in incorrect")
            .isEqualTo(option)
    }
}