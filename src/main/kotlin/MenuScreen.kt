import java.util.Scanner


import kotlin.collections.toList

class MenuScreen<T>(
    private val title: String,
    private val items: List<T>,
    private val onItemSelected: (T) -> Unit,
    private val onCreateNew: () -> Unit,
    private val onExit: () -> Unit
) {
    companion object {
        private val scanner = Scanner(System.`in`)
    }

    fun show() {
        val itemsSnapshot = items.toList()

        while (true) {
            println("\n=== $title ===")
            if (itemsSnapshot.isEmpty()) {
                println("Список пуст. Чтобы создать элемент, выберите пункт 'Создать'")
            } else {
                itemsSnapshot.forEachIndexed { index, item ->
                    println("${index + 1}. $item")
                }
            }
            println("${itemsSnapshot.size + 1}. Создать")
            println("0. Выход")
            print("Выберите пункт (0-${itemsSnapshot.size + 1}): ")
            val input = scanner.nextLine().trim()
            val choice = input.toIntOrNull()
            if (choice == null) {
                println("Ошибка: введите цифру.")
                continue
            }
            when (choice) {
                0 -> {
                    onExit()
                    return

                }

                in 1..itemsSnapshot.size -> {
                    onItemSelected(itemsSnapshot[choice - 1])
                    return
                }

                itemsSnapshot.size + 1 -> {
                    onCreateNew()
                    return
                }

                else -> {
                    println("Ошибка: нет пункта с номером $choice.")
                    println("Доступные номера: 0-${itemsSnapshot.size + 1}")
                }
            }

        }
    }
}