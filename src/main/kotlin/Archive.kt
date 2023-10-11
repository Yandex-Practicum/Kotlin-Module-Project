import java.util.Scanner

class Archive(name: String) : Page(name) {
    private val list: MutableList<Note> = mutableListOf()

    fun show() {
        val message: String = "$name \n" +
                "\"q\" вернуться в предыдущее меню \n" +
                "0. Cоздать заметку"

        navigate(
            message,
            list,
            onCreate = { this.createNote() },
            onClick = { value -> this.list[value].show() },
        )
    }

    private fun createNote() {
        println("Введите название заметки:")
        val name = Scanner(System.`in`).nextLine()
        println("Введите содержание заметки:")
        val content = Scanner(System.`in`).nextLine()
        list.add(Note(name, content))
    }
}