package fr.ltds.exchangefile.reader

import org.apache.poi.ss.usermodel.Cell
import org.apache.poi.ss.usermodel.Row
import org.apache.poi.ss.usermodel.Sheet
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import java.io.File

open class POIReader(
    private val file: File,
    override val status: Boolean
) : Reader {

    private val workbook: XSSFWorkbook

    init {
        if (status) {
            workbook = XSSFWorkbook(file)
        } else {
            workbook = XSSFWorkbook()
        }
    }

    override fun readDescription(sheetname: String): HashMap<String, Double> {
        if (!this.checkIfReadingIsPossible()) {
            throw Error("Can't reading an empty file")
        }

        var description: HashMap<String, Double> = HashMap()
        val sheet: Sheet = this.getSheet(sheetname)

        val rowIterator: Iterator<Row> = sheet.iterator()
        while(rowIterator.hasNext()) {
            var row: Row = rowIterator.next()

            var keyCell: String = row.getCell(0).getStringCellValue()
            var valueCell: Double = row.getCell(1).getNumericCellValue()
            description[keyCell] = valueCell
        }

        return description
    }
    //fun readData() {}
    //fun readResults() {}

    private fun getSheet(sheetname: String): Sheet {
        return workbook.getSheet(sheetname)
    }
}