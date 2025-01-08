class Menu(val title: String) {
    private val options = mutableListOf<Pair<String, () -> Unit>>()

    fun addOption(description: String, action: () -> Unit) {
        options.add(description to action)
    }

    fun show() {
        while (true) {
            println("\n$title")
            options.forEachIndexed { index, option ->
                println("$index. ${option.first}")
            }
            println("Введите номер пункта:")

            val input = readLine()?.trim()
            val index = input?.toIntOrNull()

            if (index != null && index in options.indices) {
                options[index].second()
                return
            } else {
                println("Некорректный ввод. Попробуйте снова.")
            }
        }
    }
}
