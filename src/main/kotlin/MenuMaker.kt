object MenuMaker {
    fun <T : Menu> showMenu(
        contentOfMenu: String = "archive",
        listOfElements: MutableList<T>,
        onCreate: (MutableList<Note>) -> Unit,
        onSelect: (Menu) -> Unit,
        onExit: () -> Unit,
    ) {
        while (true) {
            if (contentOfMenu==("archive")) {
                println("[0] Создать архив")
            } else {
                println("[0] Создать заметку")
            }
            listOfElements.forEachIndexed { index, element -> println("[${index + 1}] ${element.name}") }
            if (contentOfMenu==("archive")) {
                println("[${listOfElements.size + 1}] Выход из программы")
            } else {
                println("[${listOfElements.size + 1}] Выход из меню")
            }

            when (val inputFromConsole = checkUserInput(listOfElements.size)) {
                0 -> onCreate(listOfElements as MutableList<Note>)
                (listOfElements.size + 1) -> {
                    onExit()
                    break
                }
                else -> {
                    onSelect(listOfElements[inputFromConsole - 1])
                }
            }
        }
    }
}

