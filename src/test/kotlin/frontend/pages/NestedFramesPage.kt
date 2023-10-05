package frontend.pages

import net.serenitybdd.core.annotations.findby.FindBy
import net.serenitybdd.core.pages.PageObject
import net.serenitybdd.core.pages.WebElementFacade

class NestedFramesPage : PageObject() {

    @FindBy(name = "frame-top")
    private lateinit var frameTop: WebElementFacade

    @FindBy(name = "frame-left")
    private lateinit var topLeftFrame: WebElementFacade

    @FindBy(name = "frame-right")
    private lateinit var topRightFrame: WebElementFacade

    @FindBy(name = "frame-middle")
    private lateinit var topMiddleFrame: WebElementFacade

    @FindBy(name = "frame-bottom")
    private lateinit var childBottomFrame: WebElementFacade

    @FindBy(css = "body")
    private lateinit var frameText: WebElementFacade

    private fun switchToFrame(frameId: String) {
        when(frameId) {
            "Top Left" -> this.driver.switchTo().frame(topLeftFrame)
            "Top Middle" -> this.driver.switchTo().frame(topMiddleFrame)
            "Top Right" -> this.driver.switchTo().frame(topRightFrame)
            "Bottom" -> this.driver.switchTo().frame(childBottomFrame)
        }
    }

    private fun navigateToExpectedFrameLayer(frameId: String) {
        if(frameId != "Bottom") {
            this.driver.switchTo().frame(frameTop)
        }
        switchToFrame(frameId)
    }

    fun getFrameText(frameId: String): String {
        navigateToExpectedFrameLayer(frameId)
        val frameText = frameText.text
        if(frameId != "Bottom"){
            this.driver.switchTo().parentFrame().switchTo().parentFrame()
        } else {
            this.driver.switchTo().parentFrame()
        }
        return frameText
    }



}