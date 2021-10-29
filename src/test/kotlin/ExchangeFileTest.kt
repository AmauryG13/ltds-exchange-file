import fr.ltds.exchangefile.ExchangeFile
import junit.framework.*
import java.io.File

class ExchangeFileTest : TestCase() {
    private val filename = "src/test/kotlin/test.xlsx"

    override fun tearDown() {
        super.tearDown()
        //val testFile: File = File(filename)
        //testFile.delete()
    }

    fun testWriteDescription() {
        var description: HashMap<String, Double> = HashMap()
        description["Test"] = 1000.toDouble()

        val file: ExchangeFile = ExchangeFile(filename)
        file.writeDescription(description)
    }

    fun testReadDescription() {
        val file: ExchangeFile = ExchangeFile(filename)
        val description: HashMap<String, Double> = file.readDescription()

        println(description.toString())
    }
}