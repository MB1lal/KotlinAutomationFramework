package pages

import net.serenitybdd.core.annotations.findby.FindBy
import net.serenitybdd.core.pages.PageObject
import net.serenitybdd.core.pages.WebElementFacade
import org.openqa.selenium.Alert

class JSAlertPage : PageObject() {
    
    @FindBy(css = "button[onclick='jsAlert()']")
    private lateinit var btnJSAlert: WebElementFacade

    @FindBy(css = "button[onclick='jsConfirm()']")
    private lateinit var btnJSConfirm: WebElementFacade

    @FindBy(css = "button[onclick='jsPrompt()']")
    private lateinit var btnJSPrompt: WebElementFacade

    @FindBy(id = "result")
    private lateinit var lblResult: WebElementFacade
    
    private lateinit var alert: Alert
    
    fun triggerJSAlert(alertType: String) {
        when(alertType) {
            "JS Alert" -> btnJSAlert.click()
            "JS Confirm" -> btnJSConfirm.click()
            "JS Prompt" -> btnJSPrompt.click()
            else -> throw IllegalArgumentException("Invalid alert type specified")
        }
    }

    fun getResultText(): String = lblResult.text

    fun interactWithAlert(interaction: String) {
        alert = this.driver.switchTo().alert()
        when(interaction) {
            "OK" -> alert.accept()
            "CANCEL" -> alert.dismiss()
            else -> throw  IllegalArgumentException("Invalid interaction specified")
        }
    }

    fun enterTextIntoAlert(inputText: String) {
        alert = this.driver.switchTo().alert()
        alert.sendKeys(inputText)
    }
    
    
    
    





}