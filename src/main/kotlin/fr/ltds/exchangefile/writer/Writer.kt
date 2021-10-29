package fr.ltds.exchangefile.writer

interface Writer {
    fun writeDescription(sheetname: String, description: HashMap<String, Double>)
    //fun writeData(acceleration: Array<Int>, force: Array<Int>)
    //fun writeResults(results: HashMap<String, Int>)
}