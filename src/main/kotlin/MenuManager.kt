import java.util.Scanner

/*класс, который содержит код:
По выводу пунктов меню;
По чтению пользовательского ввода;
По выполнению определённых операций на выбор пункта меню.*/
class MenuManager {
    val scanner: Scanner = Scanner(System.`in`)

    fun showMenu(element: List<String>) {
        element.forEachIndexed { index, option ->
            println("${index + 1}. $option")
        }
    }

    fun getUserInput():Int {

        while (true) {
            print("Выберите номер раздела: ")
            val input = if (scanner.hasNextLine()){
                scanner.nextLine()
            } else ""
            if (input.isEmpty()) {
                println("Ввод не коректный.")
                continue
            }

            val userInput = input.toIntOrNull()
            if (userInput == null || userInput <= 0) {
                println("Ввод не коректный.")
            } else {
                return userInput
            }
        }
    }

}


