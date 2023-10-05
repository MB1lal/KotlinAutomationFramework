package steps.frontend.pages

import net.serenitybdd.core.pages.PageObject
import net.serenitybdd.core.pages.WebElementFacade
import org.openqa.selenium.support.FindBy


class CheckboxesPage : PageObject() {


    @FindBy(css = "#checkboxes > input:first-of-type")
    private lateinit var checkbox1: WebElementFacade

    @FindBy(css = "#checkboxes  > input:nth-of-type(2)")
    private lateinit var checkbox2: WebElementFacade

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