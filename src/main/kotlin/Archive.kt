class Archive(private val name: String) : Menu() {
override val menuTitle: String = "Архив $name"
override val menuItemName: String = "Заметка"

    override fun toString(): String {
        return name
    }
    override fun add() {
        println("Введите название заметки.")
        getText()
            ?.let { title ->
                addItem(Note(title))
                println("Добавлена заметка \"$title\".")
            }
            ?: println("Нечитаемое название заметки.")
    }

    override fun remove() {
        println("Введите индекс заметки.")
        getIndex()
            ?.let { index ->
                removeItem(index)
                println("Заметка удалена.")
            }
            ?: println("Неверный индекс заметки.")
    }

    override fun select() {
        println("Введите индекс заметки.")
        getIndex()
            ?.let { index -> selectItem(index) }
            ?: println("Неверный индекс заметки.")
    }

    override fun show() {
        println("Заметки:")
        showItem()
    }
}