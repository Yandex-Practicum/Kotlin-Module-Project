package screens

import screens.MenuUtils.getChoice
import screens.MenuUtils.goToMenuItem
import screens.MenuUtils.printMenu
import model.MenuItem
import data.DataSource

object ChooseArchiveScreen {
    fun start() {
        while (true) {
            val elements: MutableList<MenuItem> = mutableListOf()
            elements.add(MenuItem(1, "Создать новый архив", operation = { CreateArchiveScreen.start() }))
            var i = 2
            for (archive in DataSource.getArchives()) {
                elements.add(MenuItem(i, archive.toString(), operation = { ChooseNoteScreen.start(archive.id) }))
                i++
            }
            elements.add(MenuItem(i, "Выход", null))
            printMenu("Меню выбора архива", elements)
            val choice = getChoice(elements)
            if (choice != null) {
                if (choice == i) return
                goToMenuItem(choice, elements)
            }
        }
    }
}