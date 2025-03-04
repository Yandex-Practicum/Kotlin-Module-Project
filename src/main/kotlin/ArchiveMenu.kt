class ArchiveMenu : BaseMenu<String>(
    mutableListOf(), MenuUtils(), "архивов", "Создать архив"
) {

    private val noteMenu = NoteMenu()

    override fun menuItemSelected(item: String) {
        println("Выбран архив: $item")
        noteMenu.show()
    }

    override fun createItem() {
        println("Напишите имя архива:")
        val name = readln().trim()
        if (name.isNotEmpty()) {
            items.add(name)
            println("Поздравляю, архив \"$name\" успешно создан.")
        } else {
            println("Имя архива не может быть пустым, введите название.")
        }
    }

    fun show() {
        showMenu()
    }
}