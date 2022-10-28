package archives

import base.Archive
import listOfArchives
import notes.ChooseNoteScreen
import notes.CreateNoteScreen
import java.util.*

object ChooseArchiveScreen {

    fun openArchive() {
        while (true) {
            println("Введите название архива или цифру < 0 > для возвращения в главное меню")
            val archiveName = Scanner(System.`in`).nextLine().toString()

            if (archiveName == "0") return

            val archive = listOfArchives.find { it.name == archiveName }

            if (archive == null) {
                println("Такого архива нет, введите корректное название")
                continue
            }

            showNotes(archive)

            while (true) {
                showOptions()
                when (Scanner(System.`in`).nextLine().toString()) {
                    "1" -> CreateNoteScreen.createNote(archive)
                    "2" -> ChooseNoteScreen.openNote(archive)
                    "3" -> showNotes(archive)
                    "0" -> return
                    else -> println("Неправильная команда!!!")
                }
            }
        }
    }

    fun showArchives() {
        if (listOfArchives.isEmpty()) {
            println("Список архивов пуст")
        } else {
            println("Список архивов:")
            listOfArchives.forEach {
                println(it.name)
            }
        }
    }

    private fun showOptions() {
        println()
        println("------------------------------------------------")
        println("Чтобы создать заметку нажмите - 1")
        println("Чтобы открыть заметку нажмите - 2")
        println("Чтобы показать список заметок нажмите - 3")
        println("Чтобы вернуться назад нажмите - 0")
        println("------------------------------------------------")
        println()
    }

    private fun showNotes(archive: Archive) {
        if (archive.listOfNotes.isEmpty()) {
            println("Список заметок пуст!")
        } else {
            archive.listOfNotes.forEach {
                println("Заметка с названием - ${it.name}")
            }
        }
        println()
    }
}