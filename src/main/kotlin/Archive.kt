import java.util.Scanner

class Archive(name: String) : Page(name) {
    private val list: MutableList<Note> = mutableListOf()
    override fun toString(): String {
        return "заметку"
    }
    override fun show() {
        navigate(list)
    }

    override fun create() {
        println("Введите название заметки:")
        val name = Scanner(System.`in`).nextLine()
        println("Введите содержание заметки:")
        val content = Scanner(System.`in`).nextLine()
        list.add(Note(name, content))
    }
}