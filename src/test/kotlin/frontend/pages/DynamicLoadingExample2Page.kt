package frontend.pages

import net.serenitybdd.core.pages.PageObject
import net.serenitybdd.core.pages.WebElementFacade
import org.openqa.selenium.By
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait
import java.time.Duration

class DynamicLoadingExample2Page : PageObject() {

    @FindBy(css = "#start > button")
    private lateinit var btnStart: WebElementFacade

    private val loadingBar: By = By.id("loading")

    @FindBy(id = "finish")
    private lateinit var txtHello: WebElementFacade

    fun clickStart() = btnStart.click()

    private fun waitForLoadingBarToFinish() {
        WebDriverWait(this.driver, Duration.ofSeconds(30))
            .until(ExpectedConditions.invisibilityOfElementLocated(loadingBar))
    }

    fun getLoadedElementText(): String {
        waitForLoadingBarToFinish()
        return txtHello.text
    }
}