package fr.ltds.exchangefile.writer

import org.apache.poi.ss.usermodel.Cell
import org.apache.poi.ss.usermodel.Row
import org.apache.poi.ss.usermodel.Sheet
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import java.io.File
import java.io.FileOutputStream
import java.io.OutputStream

open class POIWriter(
    private val file: File,

    ) : Writer {
    private val workbook: XSSFWorkbook = XSSFWorkbook()

    override fun writeDescription(sheetname: String, description: HashMap<String, Double>) {
        val sheet: Sheet = this.createSheet(sheetname);

        var rowId: Int = 0;
        description.forEach{(key, value) ->
            var row: Row = sheet.createRow(rowId++)

            var keyCell: Cell = row.createCell(0)
            keyCell.setCellValue(key)

            var valueCell: Cell = row.createCell(1)
            valueCell.setCellValue(value)
        }

        this.write()
    }

    //fun writeData(acceleration: Array<Int>, force: Array<Int>) {
    //    val type: String = "data"
    //    val sheet: Sheet = this.createSheet(type);
    //
    //}

    //fun writeResults(type: String, results: HashMap<String, Int>) {
    //    val sheet: Sheet = this.createSheet(type);
    //}


    private fun write() {
        var out : OutputStream = FileOutputStream(file)
        workbook.write(out)
        out.close()
    }

    private fun createSheet(name: String): Sheet {
        return workbook.createSheet(name)
    }
}