import java.util.*

class MenuScreen(private val options: MutableList<Pair<String, (index:Int) -> Unit>>) {
    private val scanner = Scanner(System.`in`)

    fun show(): Boolean {
        val optionIndex: Int

        println("Введите цифру пункта меню:")
        options.forEachIndexed { index, option -> println("$index. ${option.first}") }

        val input = scanner.nextLine()
        if (input.toIntOrNull() == null) {
            println("Некорректный ввод. Пожалуйста, введите цифру номера меню.")
            return false
        }

        optionIndex = input.toInt()
        if (optionIndex < 0 || optionIndex >= options.size) {
            println("Некорректный ввод. Такого пункта меню не существует.")
            return false
        }

        val selectedOption = options[optionIndex]
        selectedOption.second(optionIndex)

        return optionIndex == (options.size - 1) // Проверяем была ли это команда на выход
    }
}