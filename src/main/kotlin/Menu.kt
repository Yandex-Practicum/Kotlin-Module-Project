import java.util.Scanner

class Menu(private val title: String, private val items: List<String>) {
    val scanner = Scanner(System.`in`)

    fun show(): Int? {

        while(true) {
            println("")
            println("$title")
            items.forEachIndexed { index, element -> println("[$index] - $element")}
            print("Введите номер: ")

            val input = scanner.nextLine()
            val number =  input.toIntOrNull()

            if(number == null) {
                showError("Нужно ввести число!")
                continue
            }

            if(number < 0 || number >= items.size) {
                showError("Нет такого пункта!")
                continue
            }

            return number
        }
    }

    fun showError(message: String) {

        println("")
        println("ОШИБКА: $message")
    }
}