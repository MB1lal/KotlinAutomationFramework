package pages

import net.serenitybdd.annotations.DefaultUrl
import net.thucydides.core.pages.PageObject
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import java.lang.IllegalArgumentException
import java.util.Locale

@DefaultUrl("page:herokuURL")
class HerokuMainPage : PageObject() {

    @FindBy(linkText = "Form Authentication")
    private lateinit var formAuthentication: WebElement

    @FindBy(linkText = "Checkboxes")
    private lateinit var checkBoxesPage: WebElement

    @FindBy(linkText = "Dropdown")
    private lateinit var dropdownPage: WebElement

    @FindBy(linkText = "Dynamic Loading")
    private lateinit var dynamicLoading: WebElement

    @FindBy(xpath = "//*[text() = 'File Download']")
    lateinit var fileDownloadPage: WebElement

    @FindBy(xpath = "//*[text() = 'File Upload']")
    lateinit var fileUploadPage: WebElement

    @FindBy(xpath = "//*[text() = 'Frames']")
    lateinit var framesPage: WebElement

    @FindBy(xpath = "//*[text() = 'Hovers']")
    lateinit var hoversPage: WebElement

    @FindBy(xpath = "//*[text() = 'JavaScript Alerts']")
    lateinit var jsAlertsPage: WebElement

    init {
        org.openqa.selenium.support.PageFactory.initElements(this.driver, this)
    }

    fun navigateToPage(pageName: String) {
        this.open()
        when(pageName.lowercase(Locale.getDefault())) {
            "form authentication" -> formAuthentication.click()
            "checkboxes" -> checkBoxesPage.click()
            "dropdown" -> dropdownPage.click()
            "dynamic loading" -> dynamicLoading.click()
            "file download" -> fileDownloadPage.click()
            "file upload" -> fileUploadPage.click()
            "frames" -> framesPage.click()
            "hovers" -> hoversPage.click()
            "javascript alerts" -> jsAlertsPage.click()
            "login" -> TODO()
            "multiple windows" -> TODO()
            "notification messages" -> TODO()
            else -> throw IllegalArgumentException("Invalid page specified")
        }
    }
}