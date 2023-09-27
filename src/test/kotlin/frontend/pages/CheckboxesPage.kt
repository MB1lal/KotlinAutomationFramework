package frontend.pages

import net.serenitybdd.annotations.DefaultUrl
import net.serenitybdd.core.pages.PageObject
import net.serenitybdd.core.pages.WebElementFacade
import org.openqa.selenium.support.FindBy

@DefaultUrl("page:herokuURL")
class CheckboxesPage : PageObject() {

    @FindBy(linkText = "Checkboxes")
    private lateinit var checkBoxesPage: WebElementFacade

    @FindBy(css = "#checkboxes > input:first-of-type")
    private lateinit var checkbox1: WebElementFacade

    @FindBy(css = "#checkboxes  > input:nth-of-type(2)")
    private lateinit var checkbox2: WebElementFacade

    fun navigateToAuthPage() {
        this.driver.manage().window().maximize()
        this.open()
        checkBoxesPage.click()
    }

    fun clickCheckbox(index: Int) {
        if(index == 1) {
            checkbox1.click()
        }
        if(index == 2) {
            checkbox2.click()
        }
    }

    fun isChecked(index: Int): Boolean {
        if(index == 1) {
           return checkbox1.isSelected
        }
        if(index == 2) {
            return checkbox2.isSelected
        }
        return false
    }

}