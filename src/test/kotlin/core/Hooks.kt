package core

import io.cucumber.java.Before
import net.serenitybdd.cucumber.suiteslicing.SerenityTags

class Hooks : BaseSteps() {

    @Before
    fun before() {
        SerenityTags.create().tagScenarioWithBatchingInfo()
    }

}