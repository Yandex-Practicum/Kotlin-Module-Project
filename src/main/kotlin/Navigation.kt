import java.util.Scanner

open class Navigation(open val text: String, open val items :List<Pair<String, () -> Unit>>) {
    val scanner = Scanner(System.`in`)
    var running = true
    open fun watch() {
        while (running) {
            println(text)
            items.forEachIndexed { index, (name, _) ->
                println("$index. $name")
            }//про деструктуризацию я узнал через Искусственный Интелект, это гораздо круче чем писать ненужную переменную, я не знаю почему такая важная и полезная информация отсутствует в учебном материале
            val input = scanner.nextLine()
            val number = input.toIntOrNull()
            if (number == null) {
                println("Введите цифру")
                continue
            }
            if (number !in 0 until items.size) {
                println("Такой цифры нет")
                continue
            }

            val action = items[number].second
            action()
        }
    }
}
