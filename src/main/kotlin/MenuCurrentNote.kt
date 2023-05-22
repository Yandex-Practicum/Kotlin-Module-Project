// menu 4

class MenuCurrentNote: Menu() {

    override fun createMenu(currentChoice: CurrentChoice): MutableMap<Int, MenuItem> {
        val menuList: MutableMap<Int, MenuItem> = mutableMapOf()
        val userInput = UserInput()
        val note = currentChoice.listArchives[currentChoice.currentArchive].notes[currentChoice.currentNote]

        menuList[-1] = MenuItem("РАБОТА С ЗАМЕТКОЙ (Выбрана заметка '${note.noteName})'") {}
        menuList[0] = MenuItem("Внести текст в заметку") {
            println("Введите текст")
            note.data = userInput.getUserAnswerStringName()
            currentChoice.numberListMenu = 4
        }

        menuList[1] = MenuItem("Просмотреть заметку") {
            println( note.data )
            currentChoice.numberListMenu = 4
        }

        menuList[2] = MenuItem("Вернуться в прерыдущее меню") { currentChoice.numberListMenu = 2 }

        return menuList
    }
}