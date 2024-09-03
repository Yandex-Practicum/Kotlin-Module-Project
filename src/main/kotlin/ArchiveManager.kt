
import java.util.Scanner
class ArchiveManager {
    private val archives = mutableListOf<Archive>()

    fun showArchiveMenu() {
        val menuScreen = MenuScreen()
        val options = mutableListOf<Pair<String, () -> Unit>>(
            "Создать архив" to ::createArchive,
            "Выход" to ::exitApp
        )

        archives.forEachIndexed { index, archive ->
            options.add("${index + 2}. ${archive.name}" to { showNotesMenu(archive) })
        }

        menuScreen.showMenu("Список архивов:", options)
    }

    private fun createArchive() {
        println("Введите название архива:")
        val name = readLine().orEmpty().trim()
        if (name.isNotEmpty()) {
            val archive = Archive(name)
            archives.add(archive)
            println("Архив \"$name\" создан.")
        } else {
            println("Название архива не может быть пустым.")
        }
        showArchiveMenu()
    }

    private fun showNotesMenu(archive: Archive) {
        val notesManager = NotesManager(this, archive)
        notesManager.showNotesMenu()
    }

    private fun exitApp() {
        println("Выход из приложения.")
    }
}