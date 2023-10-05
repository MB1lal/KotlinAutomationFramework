package frontend.pages

import net.serenitybdd.core.pages.PageObject
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import org.openqa.selenium.By
import java.io.BufferedReader
import java.io.InputStreamReader

class FileDownloadPage : PageObject() {

    private val logger: Logger = LogManager.getLogger(FileDownloadPage::class.java)
    fun downloadFile(fileName: String) {
        val fileURL = this.driver.findElement(By.linkText(fileName)).getAttribute("href")
        val downloadDir = System.getProperty("user.dir") + "/src/test-output/downloads"
        val command = "wget -P $downloadDir $fileURL"
        try {
            // Start a new process for the command
            val process = ProcessBuilder(command.split(" "))
                .redirectErrorStream(true)
                .start()
            // Read and print the output of the command
            val reader = BufferedReader(InputStreamReader(process.inputStream))
            var line: String?
            while (reader.readLine().also { line = it } != null) {
                logger.debug(line)
            }
            // Wait for the process to complete
            val exitCode = process.waitFor()
            println("Command exited with code: $exitCode")
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    

}