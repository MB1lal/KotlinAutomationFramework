package pages

import net.thucydides.core.pages.PageObject
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory
import org.openqa.selenium.support.ui.Select

class DropdownPage : PageObject() {

    @FindBy(id = "dropdown")
    private lateinit var dropdownElement: WebElement

    private var dropdown: Select

    init {
        PageFactory.initElements(this.driver, this)
        dropdown = Select(dropdownElement)
    }

    fun selectDropdownOption(option: String) = dropdown.selectByVisibleText(option)

    fun getDropdownSelectedOption(): String = dropdown.firstSelectedOption.text
}