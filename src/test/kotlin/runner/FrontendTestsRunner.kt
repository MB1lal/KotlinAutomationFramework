package runner

import io.cucumber.junit.CucumberOptions
import net.serenitybdd.cucumber.CucumberWithSerenity
import org.junit.runner.RunWith

@RunWith(CucumberWithSerenity::class)
@CucumberOptions(
    features = ["src/test/resources/features/frontend"],
    tags = "@test and not @ignore and @herokuapp",
    glue = ["frontend.steps"]

)
class FrontendTestsRunner {
}