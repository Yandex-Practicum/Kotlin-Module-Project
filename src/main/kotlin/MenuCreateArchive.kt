// menu 1

class MenuCreateArchive : Menu() {

    override fun createMenu(currentChoice: CurrentChoice): MutableMap<Int, MenuItem> {
        val menuList: MutableMap<Int, MenuItem> = mutableMapOf()
        val userInput = UserInput()

        menuList[-1] = MenuItem("\nСОЗДАНИЕ АРХИВА\n") {}
        menuList[0] = MenuItem("Ввести имя и создать архив") {
            println("Введите имя архива")
            currentChoice.listArchives.add( Archive(userInput.getUserAnswerStringName()) )
            currentChoice.currentListMenu = ListMenu.ARCHIVES
        }

        menuList[1] = MenuItem("Отмена. Вернуться в прерыдущее меню") { currentChoice.currentListMenu = ListMenu.ARCHIVES }

        return menuList
    }
}