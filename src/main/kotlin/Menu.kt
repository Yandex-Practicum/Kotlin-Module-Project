class Menu(
    private val options: List<Pair<String, () -> Unit>>,
    private val parentMenu: Menu? = null
) {
    private fun display() {
        println(MenuMessage.MENU_HEADER.message)
        options.forEachIndexed { index, option ->
            println("$index. ${option.first}")
        }
        println(MenuMessage.MENU_EXIT_OPTION.message)
    }

    private fun readInput(): String {
        print(MenuMessage.INPUT_PROMPT.message)
        return readlnOrNull() ?: ""
    }

    private fun execute(optionIndex: Int) {
        if (optionIndex in options.indices) {
            options[optionIndex].second.invoke()
        } else if (optionIndex == -1) {
            println("Некорректный ввод.")
        } else {
            println(MenuMessage.INVALID_INPUT_MESSAGE.message)
        }
        if (optionIndex != -1) {
            println("Выход из программы.")
        }
    }


    fun start() {
        while (true) {
            display()
            val input = readInput()
            if (input == "q") {
                println("Выход из программы.")
                break
            }
            try {
                val optionIndex = input.toInt()
                execute(optionIndex)
            } catch (e: NumberFormatException) {
                println(MenuMessage.INVALID_INPUT_MESSAGE.message)
            }
        }
    }
}
