// menu 3

class MenuCreateNote: Menu() {

    override fun createMenu(currentChoice: CurrentChoice): MutableMap<Int, MenuItem> {
        val menuList: MutableMap<Int, MenuItem> = mutableMapOf()
        val userInput = UserInput()

        menuList[-1] = MenuItem("СОЗДАНИЕ ЗАМЕТКИ") {}
        menuList[0] = MenuItem("Ввести имя и создать заметку") {
            println("Введите имя заметки")
            currentChoice.listArchives[currentChoice.currentArchive].notes.add(Note(userInput.getUserAnswerStringName()))
            currentChoice.numberListMenu = 2
        }

        menuList[1] = MenuItem("Отмена. Вернуться в прерыдущее меню") { currentChoice.numberListMenu = 2 }

        return menuList
    }
}