package pages

import net.serenitybdd.core.annotations.findby.FindBy
import net.serenitybdd.core.pages.PageObject
import net.serenitybdd.core.pages.WebElementFacade

class FramesPage : PageObject() {
    
    @FindBy(xpath = "//*[text() = 'Nested Frames']")
    private lateinit var nestedFramesPage: WebElementFacade

    @FindBy(xpath = "//*[text() = 'iFrame']")
    lateinit var iFramePage: WebElementFacade

    
    
    fun navigateToXFramePage(pageName: String) {
        when(pageName) {
            "Nested Frames" -> nestedFramesPage.click()
            "iFrame" -> iFramePage.click()
            else -> throw IllegalArgumentException("Invalid frame page specified")
        }
    }
    
    
}