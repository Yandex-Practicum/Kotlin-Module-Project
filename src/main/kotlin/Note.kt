import java.util.*

class Note(override val id: Int, override val name: String, private val text: String) : MenuFields {
    private val input = Scanner(System.`in`)
    private val menuNote: MutableList<MenuFields> = mutableListOf(
        NotesMenu(0, "Вернуться в меню архива"),
        NotesMenu(1, "Показать заметку")
    )
    private val naviFunctions = NaviFunctions()

    override fun start() {
        while (true) {
            println(naviFunctions.showMenu(menuNote, "Вы внутри заметки", ""))
            val inputString = input.nextLine().toString()
            if (naviFunctions.checkInput(menuNote, inputString)) {
                val inputInt = inputString.toInt()
                if (!chooseNote(inputInt)) {
                    return
                }
            }
        }
    }

    private fun chooseNote(inputInt: Int): Boolean {
        for (m in menuNote) {
            return when (inputInt) {
                0 -> {
                    println("Возвращаемся в меню архива")
                    false
                }
                1 -> {
                    println(text)
                    true
                }
                else -> {
                    true
                }
            }
        }
        return true
    }
}