import java.util.Scanner

class Archive(
    val name: String
) : Page() {
    private val list: MutableList<Note> = mutableListOf()

    fun show() {
        while (true) {
            println(
                "$name \n" +
                        "\"q\" вернуться в предыдущее меню \n" +
                        "0. Cоздать заметку"
            )
            for (i in list)
                println("${list.indexOf(i) + 1}. ${i.name}")

            var stop = false
            navigate(
                onCreate = {this.createNote() },
                onClick = {value -> this.list[value].show()},
                onExit = {stop = true}
            )
            if (stop) break
        }
    }

    private fun createNote() {
        println("Введите название заметки:")
        val name = Scanner(System.`in`).nextLine()
        println("Введите содержание заметки:")
        val content = Scanner(System.`in`).nextLine()
        list.add(Note(name, content))
    }
}