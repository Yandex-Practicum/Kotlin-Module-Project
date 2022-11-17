import java.util.Scanner

class Note(override val id: Int, override val name: String, private val text: String) : MenuFields {
    private val input = Scanner(System.`in`)
    private val menuNote: MutableList<MenuFields> = mutableListOf(
        NotesMenu(0, "Вернуться в меню архива"),
        NotesMenu(1, "Показать заметку")
    )

    override fun start() {
        while (true) {
            println(NaviFunctions.showMenu(menuNote, "Вы внутри заметки", ""))
            val inputString = input.nextLine().toString()
            if (NaviFunctions.checkInput(menuNote, inputString)) {
                val inputInt = inputString.toInt()
                if (!chooseNote(inputInt)) {
                    return
                }
            }
        }
    }

    private fun chooseNote(inputInt: Int): Boolean {
        for (menu in menuNote) {
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