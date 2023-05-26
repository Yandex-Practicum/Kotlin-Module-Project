// menu 4

class MenuCurrentNote: Menu() {

    override fun createMenu(currentChoice: CurrentChoice): MutableMap<Int, MenuItem> {
        val menuList: MutableMap<Int, MenuItem> = mutableMapOf()
        val userInput = UserInput()
        val note = currentChoice.listArchives[currentChoice.currentArchive].notes[currentChoice.currentNote]

        menuList[-1] = MenuItem("\nРАБОТА С ЗАМЕТКОЙ (Выбрана заметка '${note.noteName})'\n") {}
        menuList[0] = MenuItem("Внести текст в заметку") {
            println("Введите текст")
            note.data = userInput.getUserAnswerStringName()
            currentChoice.currentListMenu = ListMenu.CURRENT_NOTE
        }

        menuList[1] = MenuItem("Просмотреть заметку") {
            println( "\n Текст заметки:\n ${note.data}" )
            currentChoice.currentListMenu = ListMenu.CURRENT_NOTE
        }

        menuList[2] = MenuItem("Вернуться в прерыдущее меню") { currentChoice.currentListMenu = ListMenu.NOTES }

        return menuList
    }
}