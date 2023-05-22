// menu 2

class MenuNotes : Menu() {

    override fun createMenu(currentChoice: CurrentChoice): MutableMap<Int, MenuItem> {
        val menuList: MutableMap<Int, MenuItem> = mutableMapOf()
        var i = 0

        menuList[-1] =
            MenuItem("ВЫБОР ЗАМЕТКИ (Выбран архив '${currentChoice.listArchives[currentChoice.currentArchive].archiveName}')") {}
        menuList[i] = MenuItem("Создать заметку") { currentChoice.numberListMenu = 3 }

        val list = currentChoice.listArchives[currentChoice.currentArchive].notes
        list.forEach {
            menuList[++i] = MenuItem("Заметка '${it.noteName}'") { currentChoice.numberListMenu = 4 }
            currentChoice.currentNote = list.indexOf(it)
        }

        menuList[++i] = MenuItem("Выход в предыдущее меню") { currentChoice.numberListMenu = 0 }

        return menuList
    }
}