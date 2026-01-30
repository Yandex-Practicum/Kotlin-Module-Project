package ui
import models.Archive

class ArchiveMenu(private val archives: MutableList<Archive>) : Menu<Archive>(
    title = "Меню архивов",
    createItemText = "Создать архив"
) {
    override fun getItemsList(): List<Archive> = archives

    override fun getItemName(item: Archive): String = item.name

    override fun onItemSelected(item: Archive) {
        val noteMenu = NoteMenu(item.notes)
        noteMenu.show()
    }

    override fun onCreateItem() {
        while (true) {
            val name = ConsoleReader.readLine("Введите название архива: ")

            if (name.isBlank()) {
                println("Название архива не может быть пустым")
                continue
            }

            if (archives.any { it.name.equals(name, ignoreCase = true) }) {
                println("Архив с таким названием уже существует")
                continue
            }

            archives.add(Archive(name))
            println("Архив \"$name\" создан")
            break
        }
    }
}