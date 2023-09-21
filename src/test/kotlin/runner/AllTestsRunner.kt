package runner

import io.cucumber.junit.CucumberOptions
import net.serenitybdd.cucumber.CucumberWithSerenity
import org.junit.runner.RunWith

@RunWith(CucumberWithSerenity::class)
@CucumberOptions(
    features = ["/src/test/features"],
    glue = ["backend/connectors"],
    stepNotifications = true

)
class AllTestsRunner {
}