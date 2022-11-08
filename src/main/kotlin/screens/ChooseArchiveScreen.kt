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
            elements.add(MenuItem(1, "Создать новый архив", operation = { CreateArchiveScreen.start(0) }))
            var itemIndex = 2
            for (archive in DataSource.getArchives()) {
                elements.add(MenuItem(itemIndex, archive.toString(), operation = { ChooseNoteScreen.start(archive.id) }))
                itemIndex++
            }
            elements.add(MenuItem(itemIndex, "Выход", null))
            printMenu("Меню выбора архива", elements)
            val choice = getChoice(elements)
            if (choice != null) {
                if (choice == itemIndex) return
                goToMenuItem(choice, elements)
            }
        }
    }
}