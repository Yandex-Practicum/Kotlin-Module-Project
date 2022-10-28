package archives

import base.Archive
import listOfArchives
import java.util.*

object CreateArchiveScreen {

     fun createArchive() {
        while (true) {
            println("Создаем архив, введите название архива")
            val archiveName = Scanner(System.`in`).nextLine().toString()
            listOfArchives.add(
                Archive(
                    name = archiveName,
                    listOfNotes = mutableListOf()
                )
            )
            println("Архив с названием <$archiveName> создан!")
            break
        }
    }
}