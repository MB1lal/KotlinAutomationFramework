package frontend.pages

import net.serenitybdd.annotations.DefaultUrl
import net.thucydides.core.pages.PageObject
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import java.lang.IllegalArgumentException
import java.util.Locale

@DefaultUrl("page:herokuURL")
class HerokuMainPage : PageObject() {

    @FindBy(linkText = "Form Authentication")
    private lateinit var loginPage: WebElement

    @FindBy(linkText = "Checkboxes")
    private lateinit var checkBoxesPage: WebElement

    @FindBy(linkText = "Dropdown")
    private lateinit var dropdownPage: WebElement

    @FindBy(linkText = "Dynamic Loading")
    private lateinit var dynamicLoading: WebElement

    init {
        org.openqa.selenium.support.PageFactory.initElements(this.driver, this)
    }

    fun navigateToPage(pageName: String) {
        this.open()
        when(pageName.lowercase(Locale.getDefault())) {
            "form authentication" -> loginPage.click()
            "checkboxes" -> checkBoxesPage.click()
            "dropdown" -> dropdownPage.click()
            "dynamic loading" -> dynamicLoading.click()
            else -> throw IllegalArgumentException("Invalid page specified")
        }
    }
}