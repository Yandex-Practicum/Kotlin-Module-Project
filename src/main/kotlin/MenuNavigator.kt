import java.util.InputMismatchException
import java.util.Scanner

class MenuNavigator(private val scanner: Scanner) {
    fun <T> showMenu(options: List<Pair<String, () -> T>>): T? {
        while (true) {
            options.forEachIndexed { index, option ->
                println("${index}. ${option.first}")
            }
            try {
                val choice = scanner.nextInt()
                scanner.nextLine();
                if (choice in options.indices) {
                    return options[choice].second()
                } else {
                    println("Такого пункта нет. Пожалуйста, выберите корректный.")
                }
            } catch (e: InputMismatchException) {
                println("Пожалуйста, введите цифру.")
                scanner.nextLine()

            }
        }
    }
}