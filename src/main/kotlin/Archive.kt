import java.util.Scanner

class Archive(var name: String) {
    val notes = mutableListOf<Note>()
}

object ArchiveManager {
    private val archives = mutableListOf<Archive>()
    private val scanner = Scanner(System.`in`)

    fun showArchives() {
        val archiveMenu = Menu("Список архивов")
        archiveMenu.addCommand("Создать архив", action = ({createArchive() }))
        archives.forEach() { archive ->
            archiveMenu.addCommand(archive.name, action = ({showNotes(archive) }))
        }
        archiveMenu.showMenuScreen()
    }

    private fun createArchive() {
        while (true) {
            print("Введите имя архива: ")
            val name = scanner.nextLine()
            if (name.isNotEmpty()) {
                archives.add(Archive(name))
                println("Архив создан!")
                break
            } else {
                println("Введите непустое имя архива")
            }
        }
        showArchives()
    }

    private fun showNotes(archive: Archive) {
        NoteManager.showNotes(archive)
    }

}