package steps.frontend

import io.cucumber.java.en.Then
import io.cucumber.java.en.When
import org.assertj.core.api.Assertions.assertThat
import pages.NotificationsPage
import steps.base.BaseSteps

class NotificationsSteps : BaseSteps() {

    private val notificationsPage = NotificationsPage()

    @When("I generate a new notification")
    fun shuffleNotifications() {
        logger.info("Clicking the notifications button")
        notificationsPage.clickToShuffleNotification()
    }

    @Then("I should see one of the correct notification messages")
    fun verifyNotificationMessages() {
        logger.info("Verifying notification messages")
        val expectedNotifications = listOf("Action successful", "Action unsuccesful, please try again")
        assertThat(notificationsPage.getNotificationText())
            .`as`("Incorrect notification message")
            .isIn(expectedNotifications)
    }

}