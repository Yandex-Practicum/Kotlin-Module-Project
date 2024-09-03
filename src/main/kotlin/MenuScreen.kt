class MenuScreen {
    fun showMenu(title: String, options: List<Pair<String, () -> Unit>>) {
    while (true) {
        println(title)
        options.forEachIndexed { index, option ->
            println("$index. ${option.first}")
        }
        print("Выберите пункт: ")

        val input = readLine()
        if (input != null && input.isNotBlank() && input.all { it.isDigit() }) {
            val choice = input.toInt()
            if (choice in options.indices) {
                options[choice].second.invoke()
                break
            } else {
                println("Нет такого пункта. Попробуйте еще раз.")
            }
        } else {
            println("Вы не ввели корректное число, попробуйте снова.")
        }
    }
}
}