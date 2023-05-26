// menu 2

class MenuNotes : Menu() {

    override fun createMenu(currentChoice: CurrentChoice): MutableMap<Int, MenuItem> {
        val menuList: MutableMap<Int, MenuItem> = mutableMapOf()
        var i = 0
        val currentArchive = currentChoice.listArchives[currentChoice.currentArchive]

        menuList[-1] = MenuItem("\nВЫБОР ЗАМЕТКИ (Выбран архив '${currentArchive.archiveName}')\n") {}
        menuList[i] = MenuItem("Создать заметку") { currentChoice.currentListMenu = ListMenu.CREATE_NOTES }

        currentArchive.notes.forEach { note ->
            menuList[++i] = MenuItem("Заметка '${note.noteName}'") {
                currentChoice.currentListMenu = ListMenu.CURRENT_NOTE
            }
            currentChoice.currentNote = currentArchive.notes.indexOf(note)
        }

        menuList[++i] = MenuItem("Выход в предыдущее меню") { currentChoice.currentListMenu = ListMenu.ARCHIVES }

        return menuList
    }
}