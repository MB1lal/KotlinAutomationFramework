package frontend.pages

import net.serenitybdd.annotations.DefaultUrl
import net.serenitybdd.core.pages.WebElementFacade
import net.thucydides.core.pages.PageObject
import org.openqa.selenium.support.FindBy

@DefaultUrl("page:herokuURL")
class AuthenticationPage : PageObject() {

    @FindBy(id ="username")
    private lateinit var txtUsername: WebElementFacade

    @FindBy(id = "password")
    private lateinit var txtPassword: WebElementFacade

    @FindBy(css = ".fa.fa-2x.fa-sign-in")
    private lateinit var btnLogin: WebElementFacade

    @FindBy(css = ".icon-2x.icon-signout")
    private lateinit var btnLogout: WebElementFacade

    @FindBy(linkText = "Form Authentication")
    private lateinit var loginPage: WebElementFacade

    private var loggedInText = "You logged into a secure area!"
    private var loggedOutText = "You logged out of the secure area!"

    fun navigateToAuthPage() {
        this.driver.manage().window().maximize()
        this.open()
        loginPage.click()
    }
    fun enterUsernameAndPassword(username: String, password: String) {
        txtUsername.sendKeys(username)
        txtPassword.sendKeys(password)
    }

    fun clickLogin() = btnLogin.click()

    fun userIsLoggedIn(): Boolean = this.driver.pageSource.contains(loggedInText)
    fun clickLogout() = btnLogout.click()

    fun userIsLoggedOut(): Boolean = this.driver.pageSource.contains(loggedOutText)


}