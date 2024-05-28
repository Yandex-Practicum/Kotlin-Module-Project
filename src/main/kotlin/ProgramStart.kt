import java.util.InputMismatchException
import java.util.Scanner

class ProgramStart {
    private val archiveMenu = ArchiveMenu()
    private val noteMenu = NoteMenu()

    fun archiveMenuScreen() {
        var isCloseProgram = false

        while (!isCloseProgram) {
            archiveMenu.showArchiveMenu()
            var archiveMenuOption = archiveMenu.getMenuOption()

            while (archiveMenu.isOptionWrongType) {
                archiveMenu.showArchiveMenu()
                archiveMenuOption = archiveMenu.getMenuOption()
            }

            archiveMenu.menuOptionValidate(archiveMenuOption, archiveMenu.mapOfArchives)

            if (archiveMenuOption == 0) {
                archiveMenu.createArchive()
            }

            if (archiveMenu.mapOfArchives.isNotEmpty() && archiveMenuOption in 1..archiveMenu.mapOfArchives.keys.last()) {
                var returnToArchiveMenu = false
                while (!returnToArchiveMenu) {
                    returnToArchiveMenu = noteMenuScreenUntilReturn(archiveMenuOption)
                }
            }

            if (archiveMenuOption == archiveMenu.exitFromMenuOption(archiveMenu.mapOfArchives)) {
                isCloseProgram = true
            }
        }
    }

    private fun noteMenuScreenUntilReturn(archiveIndex: Int): Boolean {
        var isReturnToArchiveMenu = false
        val mapOfArchivesNotes: MutableMap<Int, Note>? =
            archiveMenu.mapOfArchives[archiveIndex]?.mapOfNotes
        noteMenu.showNoteMenu(mapOfArchivesNotes)
        var noteMenuOption = noteMenu.getMenuOption()

        while (noteMenu.isOptionWrongType) {
            noteMenu.showNoteMenu(mapOfArchivesNotes)
            noteMenuOption = noteMenu.getMenuOption()
        }

        noteMenu.menuOptionValidate(noteMenuOption, mapOfArchivesNotes)

        if (noteMenuOption == 0) {
            noteMenu.addNoteToArchive(mapOfArchivesNotes)
        }

        if (mapOfArchivesNotes!!.isNotEmpty() && noteMenuOption in 1..mapOfArchivesNotes.keys.last()) {
            var optionToReturn = false
            while (!optionToReturn) {
                println(mapOfArchivesNotes[noteMenuOption])
                print("Введите 0, вернуться к списку заметок: ")
                try {
                    val menuOption = Scanner(System.`in`).nextInt()
                    if (menuOption == 0) {
                        optionToReturn = true
                    } else {
                        println("Неверная команда, попробуйте еще раз")
                    }
                } catch (e: InputMismatchException) {
                    println("Введен неверный тип команды, попробуйте еще раз:")
                }
            }
        }

        if (noteMenuOption == noteMenu.exitFromMenuOption(mapOfArchivesNotes)) {
            isReturnToArchiveMenu = true
        }
        return isReturnToArchiveMenu
    }
}