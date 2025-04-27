class ArchiveList : Menu() {
    override val menuTitle: String =  "Архивный список"
    override val menuItemName: String = "Архив"

    override fun toString(): String {
        return "Архивный список"
    }

    override fun add() {
        println("Введите название архива.")
        getText()
            ?.let { title ->
                addItem(Archive(title))
                println("Добавлен архив \"$title\".")
            }
            ?: println("Нечитаемое название архива.")
    }

    override fun remove() {
        println("Введите индекс архива.")
        getIndex()
            ?.let { index ->
                removeItem(index)
                println("Архив удален.")
            }
            ?: println("Неверный индекс архива.")
    }

    override fun select() {
        println("Введите индекс архива.")
        getIndex()
            ?.let { index -> selectItem(index) }
            ?: println("Неверный индекс архива.")
    }
     override fun show() {
        println("Архивы:")
        showItem()
    }
}