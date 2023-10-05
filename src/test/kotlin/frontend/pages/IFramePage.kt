package frontend.pages

import net.serenitybdd.core.annotations.findby.FindBy
import net.serenitybdd.core.pages.PageObject
import net.serenitybdd.core.pages.WebElementFacade

class IFramePage : PageObject () {

    @FindBy(id = "mce_0_ifr")
    lateinit var iFrameWithText: WebElementFacade

    @FindBy(id = "tinymce")
    lateinit var txtContent: WebElementFacade


    fun switchToIFrame() = this.driver.switchTo().frame(iFrameWithText)

    fun enterTextIntoContent(inputText: String) {
        txtContent.clear()
        txtContent.sendKeys(inputText)
    }

    fun getIFrameText(): String = txtContent.text.trim()


}