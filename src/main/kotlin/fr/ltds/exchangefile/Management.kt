package fr.ltds.exchangefile

import fr.ltds.exchangefile.reader.Reader
import fr.ltds.exchangefile.writer.Writer

interface Management {
// Object containing the file structure description
    val structure: FileStructure

// Subclasses holding the processing hook
    abstract val writer: Writer
    abstract val reader: Reader

 // Writing methods
    fun writeDescription(description: HashMap<String, Double>)
    //fun writeData()
    //fun writeResults()

// Reading methods
    fun readDescription() : HashMap<String, Double>
    //fun readData()
    //fun readResults()

}