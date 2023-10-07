package steps.frontend

import io.cucumber.java.en.Then
import io.cucumber.java.en.When
import org.assertj.core.api.Assertions.assertThat
import pages.HoversPage
import steps.base.BaseSteps

class HoverSteps : BaseSteps() {

    private val hoversPage = HoversPage()
    @When("I hover over the {} user avatar")
    fun hoverOverXUserAvatar(userIndex: String) {
        logger.info("Hovering over $userIndex user avatar")
        val userId: Int = when(userIndex) {
            "first" -> 1
            "second" -> 2
            "third" -> 3
            else -> throw IllegalArgumentException("Invalid userIndex specified")
        }
        hoversPage.hoverOverAvatar(userId)
    }

    @Then("I should see {} for the {} user")
    fun verifyInformationForXUser(expectedUser: String , userIndex: String) {
        logger.info("Verifying the user information for $userIndex user")
        val userId: Int = when(userIndex) {
            "first" -> 0
            "second" -> 1
            "third" -> 2
            else -> throw IllegalArgumentException("Invalid userIndex specified")
        }
        assertThat(hoversPage.getProfileName(userId)).`as`("Profile name is incorrect").isEqualTo(expectedUser)
    }

}