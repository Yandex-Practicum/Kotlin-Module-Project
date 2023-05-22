// menu 0

class MenuArchives : Menu() {

    override fun createMenu(currentChoice: CurrentChoice): MutableMap<Int, MenuItem> {
        val menuList: MutableMap<Int, MenuItem> = mutableMapOf()
        var i = 0

        menuList[-1] = MenuItem("ВЫБОР АРХИВА") {}
        menuList[i] = MenuItem("Создать архив") { currentChoice.numberListMenu = 1 }
        val list = currentChoice.listArchives
        list.forEach {
            menuList[++i] = MenuItem("Архив '${it.archiveName}'") {
                currentChoice.numberListMenu = 2
                currentChoice.currentArchive = list.indexOf(it)
            }
        }

        menuList[++i] = MenuItem("Выход из программы") { currentChoice.noEndProgram = false }

        return menuList
    }
}