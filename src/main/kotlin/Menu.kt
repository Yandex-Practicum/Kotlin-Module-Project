

class Menu {
    fun showMenu(items: List<String>, prompt: String): Int {
        while (true) {
            println(prompt)
            items.forEachIndexed { index, item ->
                println("$index. $item")
            }
            print("Выберите пункт: ")
            val input = readLine()
            if (input.isNullOrEmpty() || !input.matches(Regex("\\d+"))) {
                println("Пожалуйста, введите цифру.")
                continue
            }
            val choice = input.toInt()
            if (choice < 0 || choice >= items.size) {
                println("Такого пункта нет. Пожалуйста, выберите снова.")
                continue
            }
            return choice
        }
    }
}
