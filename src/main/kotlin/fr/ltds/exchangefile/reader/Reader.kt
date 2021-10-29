package fr.ltds.exchangefile.reader

interface Reader {
    abstract val status: Boolean

    fun readDescription(sheetname: String): HashMap<String, Double>
 //   fun readData()
 //   fun readResults()

    fun checkIfReadingIsPossible(): Boolean {
        return status
    }
}