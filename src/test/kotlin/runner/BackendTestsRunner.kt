package runner

import io.cucumber.junit.CucumberOptions
import net.serenitybdd.cucumber.CucumberWithSerenity
import org.junit.runner.RunWith

@RunWith(CucumberWithSerenity::class)
@CucumberOptions(
    features = ["src/test/resources/features/backend/"],
    tags = "@test and not @ignore and @backend",
    glue = ["backend.steps"],
    plugin = ["json:target/cucumber-report/cucumber.json"]
)
class BackendTestsRunner {
}