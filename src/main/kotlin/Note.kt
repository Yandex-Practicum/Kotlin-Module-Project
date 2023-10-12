import java.util.Scanner

class Note(
    name: String,
    private var content: String
) : Page(name) {
    override fun toString(): String {
        return name
    }
    private fun read() {
        while (true) {
            println(content)
            println("0. Выйти из просмотра")
            val input: Int
            val scanner = Scanner(System.`in`)
            if (scanner.hasNextInt()) {
                input = scanner.nextInt()
                if (input == 0) break
                else {
                    println("Такого пункта нет в списке.")
                    continue
                }
            }else{
                println("Введите цифру согласно пунктам меню.")
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

            val input = Scanner(System.`in`).nextInt()
            if (input == 0) this.read()
            else if (input == 1) break
        }

    }
}