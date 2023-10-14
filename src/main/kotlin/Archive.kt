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
        var noteName : String
        var content: String

        while (true) {
            println("Введите название заметки:")
            noteName = Scanner(System.`in`).nextLine()
            if (noteName.isEmpty()) {
                println("Имя не может быть пустым.")
                continue
            } else break
        }

        while (true) {
            println("Введите содержание заметки:")
            content = Scanner(System.`in`).nextLine()
            if (content.isEmpty()){
                println("Содержание не может быть пустым.")
                continue
            } else break

        }

        list.add(Note(noteName, content))
    }
}