import java.util.Scanner

class Note(
    name: String,
    private var content: String
) : Page(name) {
    override fun toString(): String {
        return name
    }
    private fun read() {
        println(content)
        while (true) {
            println("0. Выйти из просмотра")
            val input = Scanner(System.`in`).nextInt()
            if (input == 0) break
        }
    }

    override fun show() {
        while (true) {
            println(
                "$name \n" +
                        "0. Посмотреть заметку \n" +
                        "1. Вернуться в предыдущее меню"
            )

            val input = Scanner(System.`in`).nextInt()
            if (input == 0) this.read()
            else if (input == 1) break
        }

    }
}