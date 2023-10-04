package frontend.steps

import core.BaseSteps
import io.cucumber.java.en.Given
import io.cucumber.java.en.Then

class FileUploadSteps : BaseSteps() {

    @Given("I select a upload a file {}")
    fun selectingAFileToUpload(fileName: String) {
        logger.info("Uploading file: $fileName")
        TODO()
    }

    @Then("the file should be uploaded successfully")
    fun verifyFileIsDownloaded() {
        logger.info("Verifying file is successfully uploaded")
        TODO()
    }


}