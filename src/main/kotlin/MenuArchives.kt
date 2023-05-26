// menu 0

class MenuArchives : Menu() {

    override fun createMenu(currentChoice: CurrentChoice): MutableMap<Int, MenuItem> {
        val menuList: MutableMap<Int, MenuItem> = mutableMapOf()
        var i = 0

        menuList[-1] = MenuItem("\nВЫБОР АРХИВА\n") {}
        menuList[i] = MenuItem("Создать архив") { currentChoice.currentListMenu = ListMenu.CREATE_ARCHIVES }

        currentChoice.listArchives.forEach { archive ->
            menuList[++i] = MenuItem("Архив '${archive.archiveName}'") {
                currentChoice.currentListMenu = ListMenu.NOTES
                currentChoice.currentArchive = currentChoice.listArchives.indexOf(archive)
            }
        }

        menuList[++i] = MenuItem("Выход из программы") { currentChoice.noEndProgram = false }

        return menuList
    }
}