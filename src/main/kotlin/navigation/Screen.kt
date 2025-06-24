package navigation

import NoteTakingApp
import NoteTakingApp.navController
import model.Archive
import model.Note
import utils.printIndexedList
import utils.toIntOrMessage

sealed class Screen(val navController: NavController) {
    val app = navController.app

    abstract fun handleInput(): Boolean

    protected fun commonHandleInput(
        handler: (input: String) -> Boolean
    ): Boolean {
        var input: String

        do {
            input = readlnOrNull() ?: return false
            if (input == "0") {
                return false
            }
        } while (!handler.invoke(input))
        return true
    }

    protected fun numericHandleInput(
        handler: (input: Int) -> Boolean
    ): Boolean {
        return commonHandleInput { input ->
            val inputNumber = input.toIntOrMessage(NOT_A_NUMBER) ?: return@commonHandleInput false
            handler.invoke(inputNumber)
        }
    }

    companion object VALUES {
        const val INDEX_OFFSET = 2
        const val ARCHIVES_HEADER = "Archives:\n0. Exit\n1. Add Archive"
        const val NOTES_HEADER = "Notes:\n0. Exit\n1. Add Note"
        const val NOT_A_NUMBER = "Not a number! Please, enter a number"
        const val NO_SUCH_VALUE = "No such value! Please, check your input"
        const val ANY_KEY_TO_EXIT = "Press any key to exit"
        const val EMPTY_NOTE_TITLE = "Note title cannot be empty"
        const val EMPTY_ARCHIVE_TITLE = "Archive title cannot be empty"
        const val ENTER_ARCHIVE_TITLE = "Enter non-empty archive title or \"0\" to exit:"
        const val ENTER_NOTE_TITLE = "Enter non-empty note title:"
        const val ENTER_NOTE_BODY = "Feel free to write down whatever you want or \"0\" to exit:"
    }
}

class SelectArchive : Screen(navController) {

    override fun handleInput(): Boolean {
        println(ARCHIVES_HEADER)
        printIndexedList(NoteTakingApp.archives, ". ", INDEX_OFFSET)

        return numericHandleInput { inputNumber ->
            when (inputNumber) {
                1 -> {
                    navController.navigateTo(CreateArchive())
                }

                in 1..(1 + app.archives.size) -> {
                    navController.navigateTo(SelectNote(app.archives[inputNumber - 2]))
                }

                else -> {
                    println(NO_SUCH_VALUE)
                    return@numericHandleInput false
                }
            }

            return@numericHandleInput true
        }
    }

}

private class CreateArchive : Screen(navController) {
    override fun handleInput(): Boolean {
        println(ENTER_ARCHIVE_TITLE)
        return commonHandleInput { input ->

            if (input.isBlank()) {
                println(EMPTY_ARCHIVE_TITLE)
                return@commonHandleInput false
            }

            app.addArchive(input)
            navController.navigateBack()

            return@commonHandleInput true
        }
    }
}

private class SelectNote(val archive: Archive) : Screen(navController) {
    val notes = archive.notes

    override fun handleInput(): Boolean {

        println(NOTES_HEADER)
        printIndexedList(notes, ". ", INDEX_OFFSET)

        return numericHandleInput { inputNumber ->
            when (inputNumber) {
                1 -> {
                    navController.navigateTo(CreateNote(archive))
                }

                in 1..(1 + notes.size) -> {
                    navController.navigateTo(ShowNote(notes[inputNumber - 2]))
                }

                else -> {
                    println(NO_SUCH_VALUE)
                    return@numericHandleInput false
                }
            }

            return@numericHandleInput true
        }
    }
}

private class CreateNote(val archive: Archive) : Screen(navController) {

    override fun handleInput(): Boolean {
        var noteTitle = ""

        println(ENTER_NOTE_TITLE)
        commonHandleInput { inputTitle ->

            if (inputTitle.isBlank()) {
                println(EMPTY_NOTE_TITLE)
                return@commonHandleInput false
            }

            noteTitle = inputTitle

            return@commonHandleInput true
        }

        println(ENTER_NOTE_BODY)
        return commonHandleInput { inputBody ->
            if (inputBody.isBlank()) {
                println(EMPTY_NOTE_TITLE)
                return@commonHandleInput false
            }

            archive.addNote(noteTitle, inputBody)
            navController.navigateBack()

            return@commonHandleInput true
        }
    }
}

private class ShowNote(val note: Note) : Screen(navController) {

    override fun handleInput(): Boolean {
        println("${note.title}\n${note.body}")
        println(ANY_KEY_TO_EXIT)

        return commonHandleInput {
            navController.navigateBack()
            return@commonHandleInput true
        }
    }
}