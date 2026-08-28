import java.util.Scanner

class MenuItem(val title: String, val action: () -> Unit)

/**
 * Общий класс для всех экранов выбора.
 * Отвечает за вывод пунктов, чтение ввода, обработку ошибок и выход на предыдущий экран.
 *
 * @param title заголовок экрана
 * @param exitTitle название последнего пункта ("Выход" или "Назад")
 * @param itemsProvider лямбда, возвращающая актуальный список пунктов (списки меняются по ходу работы)
 */
class Menu(
    private val title: String,
    private val exitTitle: String,
    private val itemsProvider: () -> List<MenuItem>
) {
    fun show() {
        while (true) {
            val items = itemsProvider()
            printItems(items)

            if (!scanner.hasNextLine()) return // ввод закончился (Ctrl+D / Ctrl+Z)
            val input = scanner.nextLine().trim()
            val index = input.toIntOrNull()

            when {
                index == null -> println("Ошибка: нужно ввести цифру. Попробуйте ещё раз.\n")
                index == items.size -> return
                index !in items.indices -> println("Ошибка: пункта с номером $index нет. Введите корректную цифру.\n")
                else -> items[index].action()
            }
        }
    }

    private fun printItems(items: List<MenuItem>) {
        println(title)
        items.forEachIndexed { i, item -> println("$i. ${item.title}") }
        println("${items.size}. $exitTitle")
        print("Выберите пункт: ")
    }

    companion object {
        private val scanner = Scanner(System.`in`)

        /** Читает строку и не даёт ввести пустое значение. */
        fun readNonEmptyLine(prompt: String): String {
            while (true) {
                print(prompt)
                val line = scanner.nextLine().trim()
                if (line.isNotEmpty()) return line
                println("Ошибка: значение не может быть пустым.")
            }
        }
    }
}
