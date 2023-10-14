import java.util.Scanner

class Note(
    name: String,
    private var content: String
) : Page(name) {
    private fun read() {
        while (true) {
            println(content)
            println("0. Выйти из просмотра")
            val input: Int
            val scanner = Scanner(System.`in`)
            if (isDigit(scanner)) {
                input = scanner.nextInt()
            } else {
                continue
            }
            if (hasPoint(0, input)) {
                break
            } else {
                continue
            }
        }
    }

    override fun show() {
        while (true) {
            println(
                "$name \n" +
                        "0. Посмотреть заметку \n" +
                        "1. Вернуться в предыдущее меню"
            )

            val input: Int
            val scanner = Scanner(System.`in`)
            if (isDigit(scanner)) {
                input = scanner.nextInt()
            } else {
                continue
            }
            if (hasPoint(1, input)) {
                when (input) {
                    0 -> read()
                    1 -> break
                }
            } else {
                continue
            }
        }

    }
}