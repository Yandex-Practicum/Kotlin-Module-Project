package base_screens

import ConsoleUtils
import data.Item

abstract class SelectItemScreen<T : Item<C>, C> {
    var item: T? = null
    var currentItem: C? = null

    open fun show(item: T): T {
        this.item = item
        showContent()
        showMenu()
        val text = ConsoleUtils.read()
        if (text != "0") {
            select(text)
        }
        return item
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

    abstract fun showMenu()

    abstract fun select(text: String)
}