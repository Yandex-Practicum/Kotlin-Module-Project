// menu 3

class MenuCreateNote: Menu() {

    override fun createMenu(currentChoice: CurrentChoice): MutableMap<Int, MenuItem> {
        val menuList: MutableMap<Int, MenuItem> = mutableMapOf()
        val userInput = UserInput()

        menuList[-1] = MenuItem("\nСОЗДАНИЕ ЗАМЕТКИ\n") {}
        menuList[0] = MenuItem("Ввести имя и создать заметку") {
            println("Введите имя заметки")
            currentChoice.listArchives[currentChoice.currentArchive].notes.add( Note(userInput.getUserAnswerStringName()) )
            currentChoice.currentListMenu = ListMenu.NOTES
        }

        menuList[1] = MenuItem("Отмена. Вернуться в прерыдущее меню") { currentChoice.currentListMenu = ListMenu.NOTES }

        return menuList
    }
}