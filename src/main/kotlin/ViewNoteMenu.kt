class ViewNoteMenu(stack: MutableList<Menu>, private val note: Note, helper: MenuScanner) : Menu(stack, helper) {

    override fun showMenu() {
        println("Заметка: ${note.title}")
        println(note.text)
        println("1. Вернуться назад")

        while (true) {
            when (helper.getUserInput()) {
                1 -> {
                    goBack()
                    return
                }
                else -> println("Пожалуйста, введите доступные числа из пункта меню")
            }
        }
    }
}