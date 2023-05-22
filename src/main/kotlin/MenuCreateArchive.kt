// menu 1

class MenuCreateArchive : Menu() {

    override fun createMenu(currentChoice: CurrentChoice): MutableMap<Int, MenuItem> {
        val menuList: MutableMap<Int, MenuItem> = mutableMapOf()
        // var i = 0
        val userInput = UserInput()

        menuList[-1] = MenuItem("СОЗДАНИЕ АРХИВА") {}
        menuList[0] = MenuItem("Ввести имя и создать архив") {
            println("Введите имя архива")
            currentChoice.listArchives.add(Archive(userInput.getUserAnswerStringName()))
            currentChoice.numberListMenu = 0
        }

        menuList[1] =
            MenuItem("Отмена. Вернуться в прерыдущее меню") { currentChoice.numberListMenu = 0 }

        return menuList
    }
}