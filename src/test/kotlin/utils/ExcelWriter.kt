package utils

import org.apache.poi.openxml4j.exceptions.InvalidFormatException
import org.apache.poi.openxml4j.opc.OPCPackage
import org.apache.poi.ss.usermodel.Cell
import org.apache.poi.ss.usermodel.Row
import org.apache.poi.xssf.usermodel.XSSFSheet
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import org.apache.poi.xssf.usermodel.XSSFWorkbookFactory
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.IOException

class ExcelWriter {

    private val excelWriter: ExcelWriter = ExcelWriter()

    private fun ExcelWriter(): ExcelWriter = this

    fun getInstance(): ExcelWriter {
        return excelWriter
    }

    @Throws(IOException::class, InvalidFormatException::class)
    fun writeToExcel(databaseData: List<List<String?>>, fileName: String, sheetName: String?) {
        //Blank workbook
//        XSSFWorkbook workbook = new XSSFWorkbook();
        val filePath = System.getProperty("user.dir") + "/src/test/resources/data-files/" + fileName + ".xlsx"
        val inputStream = FileInputStream(filePath)
        val workbook: XSSFWorkbook = XSSFWorkbookFactory.createWorkbook(OPCPackage.open(inputStream))
        //Create a blank sheet
//        XSSFSheet sheet = workbook.createSheet(sheetName);
        val sheet: XSSFSheet = workbook.getSheet(sheetName)
        for (rownum in databaseData.indices) {
            val row: Row = sheet.createRow(rownum)
            for (cellnum in databaseData[rownum].indices) {
                val cell: Cell = row.createCell(cellnum)
                cell.setCellValue(databaseData[rownum][cellnum])
            }
        }
        try {
            //Write the workbook in file system
            val out = FileOutputStream(filePath)
            workbook.write(out)
            out.close()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}