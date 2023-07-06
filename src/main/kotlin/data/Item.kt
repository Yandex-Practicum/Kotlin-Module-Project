package data

open class Item<C>(open var name: String) {
    var content: MutableList<C> = mutableListOf()

    open fun showContent() {
        if (this == null) {
            ConsoleUtils.write("Не найдено такого элемента")
            return
        }
        if (this.content.isEmpty()) {
            ConsoleUtils.write("Содержимое пусто")
            return
        }
        ConsoleUtils.write("Список элементов:")
        content.forEach { println("$it") }
    }
}