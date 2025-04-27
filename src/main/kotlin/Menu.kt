import java.util.Scanner

abstract class Menu {
    private var list: MutableList<Menu> = mutableListOf()
    protected val scanner: Scanner = Scanner(System.`in`)

    open val menuTitle: String = ""
    open val menuItemName:String = ""

    fun start() {
        showMenu()
        handleMenu()
    }

    protected open fun showMenu() {
        println("⚍⚍⚍⚍⚍⚍⚍⚍⚍⚍⚍⚍⚍⚍⚍⚍⚍")
        println("$menuTitle:")
        println("⚍⚍⚍⚍⚍⚍⚍⚍⚍⚍⚍⚍⚍⚍⚍⚍⚍")
        println("1. Создать $menuItemName")
        println("2. Убрать $menuItemName")
        println("3. Выбрать $menuItemName")
        println("4. Показать всё")
        println("5. Выйти")
        println("⚍⚍⚍⚍⚍⚍⚍⚍⚍⚍⚍⚍⚍⚍⚍⚍⚍")
        println("Здесь могли быть рандомные цитаты при каждом запуске, но я пока не умею так делать :(.")
    }
    protected open fun handleMenu(){
        while (true) {
            scanner.nextLine().toIntOrNull()
                ?.let { value ->
                    when(value) {
                        1 -> add()
                        2 -> remove()
                        3 -> select()
                        4 -> show()
                        5 -> return
                        else -> println("Неверная команда.")
                    }
                    showMenu()
                }
                ?: println("Введите число из списка")
        }
    }
    abstract fun add()

    abstract fun remove()

    abstract fun select()

    abstract fun show()

    protected fun getText(): String? {
        val data: String?
        while (scanner.hasNext()) {
            data = scanner.nextLine()
            return data.ifEmpty { null }
        }
        return null
    }
    protected fun getIndex(): Int? {
        getText()
            ?.toIntOrNull()
            ?.let { index ->
                if ((index > 0) && (index <= list.size)) {
                    return index - 1
                } else {
                    return null
                }
            }
            ?: return null
                ?: return null
    }
    protected fun addItem(item: Menu) {
        list.add(item)
    }
    protected fun removeItem(index: Int){
        list.removeAt(index)
    }
    protected fun selectItem(index: Int){
        list.elementAt(index).start()
    }
    protected fun showItem() {
        var index = 0
        for (item in list)
            println("   ${++index}: $item")
    }
}