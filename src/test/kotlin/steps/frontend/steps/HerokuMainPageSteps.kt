package steps.frontend.steps

import steps.core.BaseSteps
import steps.frontend.pages.HerokuMainPage
import io.cucumber.java.en.Given

class HerokuMainPageSteps : BaseSteps() {
    private var herokuPage = HerokuMainPage()

    @Given("I am on the {} page")
    fun navigateToXPage(pageName: String) {
        logger.info("Navigating to $pageName")
        herokuPage.navigateToPage(pageName)
    }
}