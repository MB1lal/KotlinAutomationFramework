package steps.frontend.steps

import steps.core.BaseSteps
import steps.frontend.pages.FileDownloadPage
import io.cucumber.java.en.And
import io.cucumber.java.en.Then
import io.cucumber.java.en.When
import org.assertj.core.api.Assertions.assertThat
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths

class FileDownloadSteps : BaseSteps() {

    private var fileDownloadPage = FileDownloadPage()
    private lateinit var fileName: String
    @When("I download the file {}")
    fun downloadIsPressed(fileName: String) {
        this.fileName = fileName
        logger.info("Downloading the file $fileName")
        fileDownloadPage.downloadFile(fileName)

    }

    @Then("the file should be downloaded successfully")
    fun verifyFileIsDownloaded() {
        logger.info("Verifying the file is downloaded")
        val path: Path = Paths.get(downloadPath, fileName)
        assertThat(Files.exists(path)).`as`("File $fileName doesn't exist in the folder").isTrue()
        logger.info("The file exists")
    }
    
    @And("I should validate the content of the downloaded file")
    fun verifyContentsOfFile() {
        logger.info("Verifying the contents of file")
        val jsonString = readJsonFile("$downloadPath/example.json")
        if (jsonString != null) {
            val jsonData = parseJson(jsonString)
            assertThat(jsonData.email).`as`("email is blank").isNotBlank()
            assertThat(jsonData.email1).`as`("email1 is blank").isNotBlank()
            assertThat(jsonData.password).`as`("password is blank").isNotBlank()
            assertThat(jsonData.password1).`as`("password1 is blank").isNotBlank()
        } else {
            logger.error("Error reading JSON file")
        }
    }


}