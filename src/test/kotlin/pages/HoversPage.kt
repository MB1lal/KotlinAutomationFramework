package pages

import net.serenitybdd.core.annotations.findby.FindBy
import net.serenitybdd.core.pages.PageObject
import net.serenitybdd.core.pages.WebElementFacade
import org.openqa.selenium.By
import org.openqa.selenium.interactions.Actions

class HoversPage : PageObject() {

    @FindBy(css = ".figure:nth-child(3)")
    private lateinit var firstUser: WebElementFacade

    @FindBy(css = ".figure:nth-child(4)")
    private lateinit var secondUser: WebElementFacade

    @FindBy(css = ".figure:nth-child(5)")
    private lateinit var thirdUser: WebElementFacade

    private var profileName: By = By.cssSelector("h5")


    fun hoverOverAvatar(userId: Int) {
        val actions = Actions(this.driver)
        when(userId) {
            1 -> actions.moveToElement(firstUser).perform()
            2 -> actions.moveToElement(secondUser).perform()
            3 -> actions.moveToElement(thirdUser).perform()
        }
    }

    fun getProfileName(userId: Int): String {
        return this.driver.findElements(profileName).get(userId).text
    }
    
    


}