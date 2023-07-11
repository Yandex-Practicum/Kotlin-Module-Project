package base_screens

import ConsoleUtils
import data.Item

abstract class CreateItemScreen<T : Item<C>, C> {
    var item: T? = null

    open fun show(item: T): T {
        this.item = item
        showMenu()
        val userInput = ConsoleUtils.read()

        if (userInput != "0")
            createContent(userInput)
        return item
    }

    abstract fun showMenu()

    abstract fun createContent(text: String)
}