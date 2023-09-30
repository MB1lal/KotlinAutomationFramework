package frontend.pages

import net.serenitybdd.core.pages.PageObject
import net.serenitybdd.core.pages.WebElementFacade
import org.openqa.selenium.support.FindBy

class DynamicLoadingPage : PageObject() {
    @FindBy(partialLinkText = "Example 1")
    private lateinit var linkEx1: WebElementFacade

    @FindBy(partialLinkText = "Example 2")
    private lateinit var linkEx2: WebElementFacade

    fun navigateToExample(example: String) {
        if (example.contains("1")) {
            linkEx1.click()
        }
        if (example.contains("2")) {
            linkEx2.click()
        }
    }
}