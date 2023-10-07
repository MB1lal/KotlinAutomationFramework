package pages

import net.serenitybdd.annotations.DefaultUrl
import net.thucydides.core.pages.PageObject
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import java.util.*

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
    private lateinit var fileDownloadPage: WebElement

    @FindBy(xpath = "//*[text() = 'File Upload']")
    private lateinit var fileUploadPage: WebElement

    @FindBy(xpath = "//*[text() = 'Frames']")
    private lateinit var framesPage: WebElement

    @FindBy(xpath = "//*[text() = 'Hovers']")
    private lateinit var hoversPage: WebElement

    @FindBy(xpath = "//*[text() = 'JavaScript Alerts']")
    private lateinit var jsAlertsPage: WebElement

    @FindBy(xpath = "//*[text() = 'Multiple Windows']")
    private lateinit var multiWindowPage: WebElement

    @FindBy(xpath = "//*[text() = 'Notification Messages']")
    private lateinit var notificationsPage: WebElement

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
            "multiple windows" -> multiWindowPage.click()
            "notification messages" -> notificationsPage.click()
            else -> throw IllegalArgumentException("Invalid page specified")
        }
    }
}