package frontend.steps

import frontend.pages.CheckboxesPage
import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import io.cucumber.java.en.When
import org.assertj.core.api.Assertions.assertThat
import java.lang.AssertionError


class CheckboxesSteps : BaseSteps() {

    private var checkboxesPage = CheckboxesPage()

    @Given("I am on the checkboxes page")
    fun navigateToCheckboxesPage() {
        logger.info("Navigating to checkboxes page")
        checkboxesPage.navigateToAuthPage()
        logger.info("Navigated to checkboxes page")
    }

    @When("I toggle the {} checkbox")
    fun toggleCheckbox(index: String) {
        logger.info("Selecting $index checkbox")
       if(index.equals("First", true)) {
           checkboxesPage.clickCheckbox(1)
       } else if(index.equals("Second", true)) {
           checkboxesPage.clickCheckbox(2)
       } else {
           logger.error("Invalid checkbox is specified")
           throw AssertionError()
       }
    }

    @Then("the {} checkbox should be {}")
    fun assertBoxIsChecked(index: String, status: String) {
        logger.info("Asserting that $index box is $status")
        val isChecked: Boolean = status.equals("selected", true)
        if(index.equals("First", true)) {
            assertThat(checkboxesPage.isChecked(1))
                .`as`("Checkbox status is incorrect.")
                .isEqualTo(isChecked)
        } else if(index.equals("Second", true)) {
            assertThat(checkboxesPage.isChecked(2))
                .`as`("Checkbox status is incorrect.")
                .isEqualTo(isChecked)
        } else {
            logger.error("Invalid checkbox is specified")
            throw AssertionError()
        }
    }



}