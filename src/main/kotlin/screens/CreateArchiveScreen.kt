package screens

import data.Database

class CreateArchiveScreen {

    init {
        createArchive()
    }

    private fun createArchive() {
        print("Введите название архива: ")
        val archiveName = readLine()!!
        Database.addArchive(archiveName)
        println("Архив $archiveName успешно создан!")
    }
}