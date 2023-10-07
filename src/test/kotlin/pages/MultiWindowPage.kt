package pages

import net.serenitybdd.core.pages.PageObject
import net.serenitybdd.core.pages.WebElementFacade
import org.openqa.selenium.support.FindBy

class MultiWindowPage : PageObject() {

    @FindBy(css = "div[class='example'] a")
    private lateinit var linkClickHere: WebElementFacade

    @FindBy(css = "h3")
    lateinit var lblH3: WebElementFacade


    fun openClickHereLink() = linkClickHere.click()

    fun switchToTab(tabId: String) {
        val windowHandle = this.driver.windowHandles
        when(tabId.lowercase()) {
            "newly opened" -> this.driver.switchTo().window(windowHandle.last())
            "previous" -> this.driver.switchTo().window(windowHandle.first())
            else -> throw IllegalArgumentException("Invalid argument specified")
        }
    }
    
    fun getHeaderText():String = lblH3.text
    
    
}