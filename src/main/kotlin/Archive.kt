import java.util.Scanner

class Archive(
    val name: String
) {
    private var list: MutableList<Note> = mutableListOf()

    fun show() {
        while (true) {
            println(
                "$name \n" +
                        "\"q\" вернуться в предыдущее меню \n" +
                        "0. Cоздать заметку"
            )
            for (i in list)
                println("${list.indexOf(i) + 1}. ${i.name}")

            val input = Scanner(System.`in`).nextLine()
            if (input == "q") break
            else if (input == "0") this.createNote()
            else list[input.toInt() - 1].show()
        }
    }

    private fun createNote() {
        println("Введите название заметки:")
        val input = Scanner(System.`in`).nextLine()
        println("Введите содержание заметки:")
        val content = Scanner(System.`in`).nextLine()
        list.add(Note(input, content))
    }
}