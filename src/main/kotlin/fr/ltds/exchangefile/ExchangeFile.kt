package fr.ltds.exchangefile

import fr.ltds.exchangefile.reader.POIReader
import fr.ltds.exchangefile.writer.POIWriter
import fr.ltds.exchangefile.writer.Writer
import fr.ltds.exchangefile.reader.Reader
import org.apache.xpath.axes.HasPositionalPredChecker
import java.io.File

class ExchangeFile(
    private val filename: String,
) : Management {

    override val writer: Writer
    override val reader: Reader
    override val structure: FileStructure = FileStructure

    private val file: File = File(filename)
    private val isEmptyFile: Boolean = file.length().equals(0L)

    init {
        file.createNewFile()
        writer = POIWriter(file)
        reader = POIReader(file, !isEmptyFile)
    }


    // Writing methods implementation
    override fun writeDescription(description: HashMap<String, Double>) {
        val sheetname : String = structure.descriptionSheet
        writer.writeDescription(sheetname, description)
    }

    // Reading methods implementation
    override fun readDescription() : HashMap<String, Double> {
        val sheetname : String = structure.descriptionSheet
        return reader.readDescription(sheetname)
    }
}