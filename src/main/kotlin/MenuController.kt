import java.util.Scanner

class MenuController(private val title: String, private val exitText: String) {
    private val scanner = Scanner(System.`in`)
    val items = mutableListOf<Pair<String, () -> Unit>>()

    fun addItem(name: String, action: () -> Unit) {
        items.add(Pair(name, action))
    }

    fun readNonEmptyString(prompt: String): String {
        while (true) {
            println(prompt)
            val input = scanner.nextLine().trim()
            if (input.isEmpty()) {
                println("ошибка: поле не может быть пустым!")
                continue
            }
            return input
        }
    }
}
