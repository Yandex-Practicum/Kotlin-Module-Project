package view

import model.Archive
import presenter.Presenter
import java.lang.NumberFormatException


const val BACK = "$EXIT_COMMAND - НАЗАД"
private const val ADD = "$ADD_COMMAND - добавить заметку"

class NoteListScreen(private val archive: Archive, presenter: Presenter, function: () -> (Unit)) :
    Screen(presenter, function) {
    override fun show() {
        println("Screen #3______архив: ${archive.name}")
        println(BACK)
        println(ADD)
        println()
        presenter.showNotes(archive)
        println("____________________________________")
        while (true) {
            when (val command = scanner.nextLine()) {
                EXIT_COMMAND -> onBackPressed.invoke()
                ADD_COMMAND -> {
                    NoteCreationScreen(archive, presenter, ::show).show()
                }

                else -> {
                    try {
                        val note = archive.notes[command.toInt() - 1]
                        NoteScreen(note, presenter, ::show).show()
                    } catch (e: NumberFormatException) {
                        println(NOT_CORRECT_INPUT)
                    } catch (e: IndexOutOfBoundsException) {
                        println(THERE_IS_NO_VALUE)
                    }
                }
            }
        }
    }
}