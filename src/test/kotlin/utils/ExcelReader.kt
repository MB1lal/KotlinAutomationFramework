//package utils
//
//import com.sun.org.apache.bcel.internal.generic.Type.STRING
//import jdk.internal.icu.lang.UCharacter.NumericType.NUMERIC
//import org.apache.poi.ss.usermodel.FormulaEvaluator
//import org.apache.poi.xssf.usermodel.XSSFSheet
//import org.apache.poi.xssf.usermodel.XSSFWorkbook
//import org.apache.poi.ss.usermodel.CellType
//import java.io.File
//import java.io.FileInputStream
//import java.io.IOException
//import java.util.*
//
//class ExcelReader {
//
//    private val excelReader: ExcelReader = ExcelReader()
//
//    private fun ExcelReader() = this
//
//    fun getInstance(): ExcelReader {
//        return excelReader
//    }
//
//    /**
//     * This class deals with reading the excel file of product upload list and store into a two dimensional array list.
//     */
//    @Throws(IOException::class)
//    fun readExcel(sheetName: String?): List<List<String>> {
//        val excelData: List<List<String>> = ArrayList()
//        val filePath = System.getProperty("user.dir") + "/src/test/resources/data-files/testData.xlsx"
//        var r = 0
//        var c = 0
//        val maxCells: Int
//        //obtaining input bytes from a file
//        val fis = FileInputStream(File(filePath))
//        //creating workbook instance that refers to .xls file
//        val wb = XSSFWorkbook(fis)
//        //creating a Sheet object to retrieve the object
//        val xssfSheet: XSSFSheet = wb.getSheet(sheetName)
//        //XSSFSheet itemSheet = wb.getSheet("Item");
//        maxCells = xssfSheet.getRow(0).lastCellNum.toInt()
//        //evaluating cell type
//        val formulaEvaluator: FormulaEvaluator = wb.getCreationHelper().createFormulaEvaluator()
//        for (row in xssfSheet)  //iteration over row using for each loop
//        {
//
//            excelData.add(ArrayList())
//            for (cell in 0 until maxCells) {
//                try {
//                    when (formulaEvaluator.evaluateInCell(row.getCell(cell)).getCellType()) {
//                        NUMERIC -> {
//                            //getting the value of the cell as a number
//                            row.getCell(cell).setCellType(CellType.STRING)
//                            val s = "" + row.getCell(cell).getStringCellValue()
//                            //s = s.contains(".") ? s.replaceAll("0*$","").replaceAll("\\.$","") : s;
//                            excelData[r].add(c, s)
//                            c++
//                        }
//
//                        STRING -> {
//                            //getting the value of the cell as a string
//                            excelData[r]
//                            excelData[r].add(c, row.getCell(cell).getStringCellValue())
//                            c++
//                        }
//
//                        else -> {
//                            excelData[r].add(c, "")
//                            c++
//                        }
//                    }
//                } catch (isNUll: NullPointerException) {
//                    excelData[r].add(c, "")
//                    c++
//                }
//            }
//            r++
//            c = 0
//            //System.out.println();
//        }
//        return excelData
//    }
//
//    fun getColumnIndex(sheetIndex: String): Int {
//        val columnIndex: Int
//        columnIndex = when (sheetIndex.uppercase(Locale.getDefault())[0]) {
//            'A' -> 0
//            'B' -> 1
//            else -> throw IllegalArgumentException("Incorrect specified index")
//        }
//        return columnIndex
//    }
//}