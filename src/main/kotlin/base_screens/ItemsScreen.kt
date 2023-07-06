package base_screens

import ConsoleUtils
import data.Item

abstract class ItemsScreen<T : Item<C>, C> {
    lateinit var selectItemScreen: SelectItemScreen<T, C>
    lateinit var createItemScreen: CreateItemScreen<T, C>

    var item: T? = null

    fun show(item: T): T? {
        do {
            this.item = item
            showContent()
            showMenu()
            val inputText = ConsoleUtils.read()

            if (inputText != "0" && inputText != "1" && inputText != "2") {
                ConsoleUtils.write("Такого кода команды не существует")

            } else when (inputText) {
                "0" -> {
                    exit()
                    break
                }
                "1" -> this.item = createItemScreen.show(item)
                "2" -> this.item = selectItemScreen.show(item)
            }
        } while (true)
        return this.item
    }

    open fun showContent() {
        if (item == null) {
            ConsoleUtils.write("Не найдено такого элемента")
            return
        }
        if (item!!.content.isEmpty()) {
            ConsoleUtils.write("Содержимое пусто")
            return
        }
        item!!.showContent()
    }

    open fun showMenu() {
        ConsoleUtils.showMenu("0-выход 1-создать архив 2-открыть архив")
    }

    open fun exit() {
    }
}