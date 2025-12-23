import java.util.*

class ArchiveMenu(private val navigator: MenuNavigator) {
    private val archives = mutableListOf<Archive>()

    fun show() {
        var shouldExit = false
        while (!shouldExit) {
            val items = mutableListOf<Pair<String, () -> Unit>>()
            items.add(Pair("Создать архив", { createArchive() }))
            archives.forEachIndexed { _, archive ->
                items.add(Pair("Открыть архив: ${archive.name}", { showNotes(archive) }))
            }
            items.add(Pair("Выход", { shouldExit = true }))

            navigator.showMenu("Архивы:", items)
        }
    }

    private fun createArchive() {
        val name = navigator.readString("Введите название архива: ")
        if (name.isNotBlank()) {
            archives.add(Archive(name))
        } else {
            println("Название архива не может быть пустым.")
        }
    }

    private fun showNotes(archive: Archive) {
        NoteMenu(navigator, archive).show()
    }
}