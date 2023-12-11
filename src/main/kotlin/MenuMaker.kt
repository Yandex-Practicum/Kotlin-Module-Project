object MenuMaker {
    fun <T : Menu> showMenu(
        contentOfMenu: TypeOfMenu,
        listOfElements: MutableList<T>,
        onCreate: (MutableList<Note>) -> Unit,
        onSelect: (Menu) -> Unit,
        onExit: () -> Unit,
    ) {
        fun <T : Menu> renderArchiveMenu(menu: MutableList<T>) {
            println("[0] Создать архив")
            listOfElements.forEachIndexed { index, element -> println("[${index + 1}] ${element.name}") }
            println("[${listOfElements.size + 1}] Выход из программы")
        }
        fun <T : Menu> renderNotesMenu(menu: MutableList<T>) {
            println("[0] Создать заметку")
            listOfElements.forEachIndexed { index, element -> println("[${index + 1}] ${element.name}") }
            println("[${listOfElements.size + 1}] Выход из меню")
        }

        while (true) {
            when (contentOfMenu) {
                TypeOfMenu.ARCHIVE -> renderArchiveMenu(listOfElements)
                TypeOfMenu.NOTE -> renderNotesMenu(listOfElements)
            }
            when (val inputFromConsole = checkUserInput(listOfElements.size)) {
                0 -> onCreate(listOfElements as MutableList<Note>)
                (listOfElements.size + 1) -> {
                    onExit()
                    break
                } else -> onSelect(listOfElements[inputFromConsole - 1])
            }
        }
    }
}