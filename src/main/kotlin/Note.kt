import java.util.Scanner

class Note(
    val name: String,
    var contain: String
) {
    val menu: MutableList<String> = mutableListOf("Изменить текст заметки", "Вернуться в архив", "Показать текст заметки")
    val navigator = Navigation()
    fun showMenu() {
        while(true) {
            navigator.showMenu(menu)
            val choice = navigator.checkInput()
            when(choice) {
                0 -> changeNote()
                1 -> return
                2 -> showNote()
                }
        }
    }
    fun showNote() {
        println("Название заметки: $name\nТекст заметки: $contain")
    }

    fun changeNote() {
        println("Введите новый текст заметки:")
        contain = Scanner(System.`in`).nextLine()
        return
    }
}