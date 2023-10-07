package steps.frontend

import pages.HerokuMainPage
import io.cucumber.java.en.Given
import steps.base.BaseSteps

class HerokuMainPageSteps : BaseSteps() {
    private var herokuPage = HerokuMainPage()

    @Given("I am on the {} page")
    fun navigateToXPage(pageName: String) {
        logger.info("Navigating to $pageName")
        herokuPage.navigateToPage(pageName)
    }
}