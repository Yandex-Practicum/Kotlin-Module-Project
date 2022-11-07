import java.util.*

class Note(override val id: Int, override val name: String, private val text: String) : MenuFields {
    private val input = Scanner(System.`in`)
    private val menuNote: MutableList<MenuFields> = mutableListOf(
        MenuInNote(0, "Вернуться в меню архива"),
        MenuInNote(1, "Показать заметку")
    )
    private val bestFunctions = BestFunctions()

    override fun start() {
        while (true) {
            println(bestFunctions.showMenu(menuNote, "Вы внутри заметки", ""))
            val inputString = input.nextLine().toString()
            if (bestFunctions.checkInput(menuNote, inputString)) {
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