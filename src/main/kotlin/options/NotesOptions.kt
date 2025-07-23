package options

import objects.Archives
import objects.Notes
import objects.PunktMenu
import screens.MenuScreen
import screens.NoteTextScreen
import java.util.Scanner

class NotesOptions (private val archive: Archives) : MenuScreen() {

    fun create() {
        while(true) {
            val options = mutableListOf<PunktMenu>()

            options.add(PunktMenu("Создать заметку"){
                println("Введите название заметки")
                val scanner = Scanner(System.`in`)
                val name = scanner.nextLine()
                if (name == null){
                    println("Введите название заметки")
                    return@PunktMenu
                }

                println("Введите текст заметки")
                val text = scanner.nextLine()
                if (text == null) {
                    println("Введите текст заметки")
                    return@PunktMenu
                }
                archive.notes.add(Notes(name, text))

            })

            archive.notes.forEach { note ->
                options.add(PunktMenu(note.name) {
                    NoteTextScreen(note).showNoteText()
                })
            }

            options.add(PunktMenu("Назад") {
                return@PunktMenu
            })

            println("Заметки в архиве ${archive.name}:")
            showMenuScreen("Список заметок", options)
            return
        }

    }

}