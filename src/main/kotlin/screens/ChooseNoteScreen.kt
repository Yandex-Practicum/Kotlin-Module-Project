package screens

import data.DataSource
import screens.MenuUtils.getChoice
import screens.MenuUtils.goToMenuItem
import screens.MenuUtils.printMenu
import model.MenuItem
import java.util.*

object ChooseNoteScreen {
    fun start(archiveId: Int) {
        while (true) {
            val elements: MutableList<MenuItem> = mutableListOf()
            elements.add(MenuItem(1, "Создать новую заметку", operation = { CreateNoteScreen.start(archiveId) }))
            var i = 2
            for (note in DataSource.getNotes(archiveId)) {
                elements.add(MenuItem(i, note.name) {
                    println("$note\nВведите любой символ для возврата в меню:")
                    Scanner(System.`in`).nextLine()
                })
                i++
            }
            elements.add(MenuItem(i, "Выход", null))
            printMenu("Меню выбора заметки", elements)
            val choice = getChoice(elements)
            if (choice != null) {
                if (choice == i) return
                goToMenuItem(choice, elements)
            }
        }
    }
}