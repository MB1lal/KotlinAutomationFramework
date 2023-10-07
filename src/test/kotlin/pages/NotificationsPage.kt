package pages

import net.serenitybdd.core.annotations.findby.FindBy
import net.serenitybdd.core.pages.PageObject
import net.serenitybdd.core.pages.WebElementFacade

class NotificationsPage : PageObject() {
    @FindBy(css = "p a")
    lateinit var linkClickHere: WebElementFacade

    @FindBy(id = "flash")
    lateinit var flashNotification: WebElementFacade

    
    
    fun clickToShuffleNotification() = linkClickHere.click()

    fun getNotificationText(): String = flashNotification.waitUntilVisible<WebElementFacade?>().text.replace("×", "").trim()


}