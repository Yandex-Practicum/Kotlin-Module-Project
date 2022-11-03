package screens

import data.Database

class CreateArchiveScreen(private val database: Database) {

    init {
        createArchive()
    }

    private fun createArchive() {
        print("Введите название архива: ")
        val archiveName = readLine()!!
        database.addArchive(archiveName)
        println("Архив $archiveName успешно создан!")
    }
}