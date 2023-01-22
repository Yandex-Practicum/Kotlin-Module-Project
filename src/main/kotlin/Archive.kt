import java.util.*

class Archive(
    val name: String
) {
    val content: MutableList<Note> = mutableListOf()
    val menu: MutableList<String> = mutableListOf("Создать заметку", "Выйти в меню архивов")
    val navigator = Navigation()

    fun newNote() {
        println("Введите имя заметки, нажмите Enter и введите содержимое заметки")
        val newNote = Note(Scanner(System.`in`).nextLine(), Scanner(System.`in`).nextLine())
        content.add(newNote)
        menu.add("Открыть заметку ${newNote.name}")
    }

    fun showMenu() {
        while(true) {
            navigator.showMenu(menu)
            var index = navigator.checkInput()
            when (index) {
                0 -> newNote()
                1 -> return
                in 2..menu.size - 1 -> content.elementAt(index - 2).showMenu()
            }
        }
    }
}