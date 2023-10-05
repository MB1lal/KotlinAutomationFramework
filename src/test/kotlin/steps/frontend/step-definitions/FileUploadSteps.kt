package steps.frontend.`step-definitions`

import steps.base.BaseSteps
import steps.frontend.pages.FileUploadPage
import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import org.assertj.core.api.Assertions.assertThat

class FileUploadSteps : BaseSteps() {
    val fileUploadPage = FileUploadPage()

    @Given("I select a file to upload")
    fun selectingAFileToUpload() {
        logger.info("Uploading file")
        fileUploadPage.selectFileToUpload()
        fileUploadPage.uploadFile()
    }

    @Then("the file should be uploaded successfully")
    fun verifyFileIsDownloaded() {
        logger.info("Verifying file is successfully uploaded")
        assertThat(fileUploadPage.getHeaderText()).`as`("File not uploaded").isEqualTo("File Uploaded!")
        assertThat(fileUploadPage.getUploadedFileName()).`as`("Incorrect file uploaded").contains("UploadFile.txt")
    }


}