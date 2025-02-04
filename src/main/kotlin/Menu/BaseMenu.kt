package Menu

import java.util.Scanner
import Item.Item

class BaseMenuItem(
    val name: String,
    val action: ()-> Unit
)

abstract class BaseMenu<T: Item> (
    open val items: MutableList<T>,
    open val greeting: String,
    open val createActionName: String
) {
    private val scan = Scanner(System.`in`)
    private var getInputValue = false

    fun start() {
        greeting()
        while (!getInputValue) {
            val menuItems = menuItems()
            printMenu(menuItems)
            correctRange()

            if (scan.hasNextInt()) {
                val index = scan.nextInt()
                if (index > menuItems.lastIndex) {
                    println("Такого варианта нет. Выбирете из вариантов ниже:")
                } else {
                    menuItems[index].action()
                }
            } else {
                println("Неверный ввод!")
                scan.next()
            }
        }
    }

    private fun greeting() {
        println(greeting)
    }

    private fun correctRange() {
        println("Введите цифру от 0 до " + (items.lastIndex + 2).toString())
    }

    private fun printMenu(menuItems: List<BaseMenuItem>) {
        menuItems.forEach {
            println(menuItems.indexOf(it).toString() + ". " + it.name)
        }
    }

    abstract fun createItem(): T

    abstract fun actionForSelectedItem(item: T)

    private fun menuItems(): List<BaseMenuItem> {
        val menuItems:MutableList<BaseMenuItem> = mutableListOf(
            BaseMenuItem(createActionName, {
                var item = createItem()
                this.items.add(item)
            })
        )

        items.forEach {it
            menuItems.add(
                BaseMenuItem(it.name, {
                    actionForSelectedItem(it)
                })
            )
        }

        menuItems.add(
            BaseMenuItem("Выйти", {
                this.getInputValue = true
            })
        )
        return menuItems
    }
}