package steps.core

import io.cucumber.java.Before
import net.serenitybdd.cucumber.suiteslicing.SerenityTags

class Hooks : BaseSteps() {

    @Before
    fun before() {
        SerenityTags.create().tagScenarioWithBatchingInfo()
    }

    @Before("@download")
    fun clearDownloadedFiles() {
        logger.info("Deleting downloads folder")
        deleteDownloadsFolder()
        logger.info("Downloads folder deleted")
    }

}