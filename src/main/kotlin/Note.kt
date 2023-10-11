import java.util.Scanner

class Note(
    val name: String,
    private var content: String
): Page(name) {
    private fun read() {
        println(content)
        while(true){
            println("\"q\" для выхода")
            val input = Scanner(System.`in`).nextLine()
            if (input == "q") break
        }
    }

    fun show() {
        while (true) {
            println(
                "$name \n" +
                        "\"q\" вернуться в предыдущее меню \n" +
                        "0. Посмотреть заметку"
            )


            val input = Scanner(System.`in`).nextLine()
            if (input == "0") this.read()
            else if (input == "q") break
        }

    }
}