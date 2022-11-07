package screens.archive

import entities.Archive
import screens.BaseScreen
import java.util.*

object ArchiveCreatingScreen {

    fun createArchive(archiveList: MutableList<Archive>) {
        print("Введите имя архива: ")
        val name = Scanner(System.`in`).nextLine().toString()

        val archive = Archive(
            name = name,
            notes = mutableListOf()
        )

        archiveList.add(archive)
        BaseScreen.start()
    }
}