package steps.frontend.pages

import net.serenitybdd.core.annotations.findby.FindBy
import net.serenitybdd.core.pages.PageObject
import net.serenitybdd.core.pages.WebElementFacade

class FileUploadPage : PageObject() {

    @FindBy(id = "file-upload")
    private lateinit var btnFileUploader: WebElementFacade

    @FindBy(id = "file-submit")
    private lateinit var btnUpload: WebElementFacade

    @FindBy(css = "#content > div > h3")
    private lateinit var lblHeader: WebElementFacade

    @FindBy(id = "uploaded-files")
    private lateinit var uploadedFiles: WebElementFacade
    fun selectFileToUpload() {
        btnFileUploader.sendKeys(System.getProperty("user.dir") + "/src/test/resources/data-files/UploadFile.txt")
    }

    fun uploadFile() {
        btnUpload.click()
    }

    fun getHeaderText(): String {
        return lblHeader.text
    }

    fun getUploadedFileName(): String {
        return uploadedFiles.text
    }


}