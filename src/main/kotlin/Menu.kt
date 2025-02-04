class Menu(private val title: String) {
    private val options = mutableListOf<Pair<String, () -> Unit>>()


    fun addOption(optionText: String, action: () -> Unit) {
        options.add(Pair(optionText, action))
    }

    fun show() {
        println("\n$title")
        options.forEachIndexed { index, option ->
            println("${index + 1}. ${option.first}")
        }
    }

    fun handleInput(): Boolean {
        var validInput = false
        while (!validInput) {
            val input = readLine()?.toIntOrNull()
            if (input != null && input in 1..options.size) {
                options[input - 1].second.invoke()
                validInput = true
                return options[input - 1].first == "Выход"
            } else {
                println("Ошибка. Пожалуйста, выберите действительный пункт меню.")
            }
        }
        return false
    }
}
