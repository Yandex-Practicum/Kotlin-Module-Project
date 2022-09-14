package main.kotlin.application.ui


import main.kotlin.application.datasource.ArchiveDataSource
import main.kotlin.application.datasource.NoteDataSource
import main.kotlin.application.model.Note
import main.kotlin.framework.navigation.Navigation
import main.kotlin.framework.ui.UWidget
import main.kotlin.framework.ui.Ui
import java.util.*


class NoteNewEditScreen(navigation: Navigation, private val archiveId: UUID, private var noteId: UUID? = null) :
    UWidget(navigation) {
    private val archiveDataSource = ArchiveDataSource
    private val noteDataSource = NoteDataSource
    private val menu
        get() = listOf(noteId?.let { "EDIT" } ?: "Create", "EXIT")

    override var ui: Ui = Ui(
        header = noteId?.let { "EditNote Screen" } ?: "New Note",
        message = getNoteById(noteId)?.note ?: "create note",
        body = menu
    )

    override fun start() {
        super.start()
        inputChecker(menu) {
            onInputReceived(it)
        }
    }

    private fun onInputReceived(num: Int) {
        when (num) {
            0 -> onCreateEditReceived()
            1 -> destroy()
        }
    }

    private fun onCreateEditReceived() {
        println(noteId?.let { "Replace the Note: " } ?: "Enter the Note: ")
        val input = readLine() ?: ""
        saveNote(input)
        reDraw()
    }

    private fun saveNote(input: String) {
        val note = noteId?.let { getNoteById(it)?.copy(note = input) } ?: Note(note = input)
        noteId = note.id
        noteDataSource.put(note)
        val arch = archiveDataSource.get(archiveId)
        val notes = arch?.listOfNotes
        val newArch = arch?.copy(listOfNotes = notes?.toMutableSet()?.apply { add(note.id) } ?: emptySet())
        newArch?.let { archiveDataSource.put(it) }
    }

    override fun reDraw() {
        ui = Ui(
            header = noteId?.let { "EditNote Screen" } ?: "New Note",
            message = getNoteById(noteId)?.note ?: "create note",
            body = menu
        )
        ui.draw()
        inputChecker(menu) {
            onInputReceived(it)
        }
    }

    private fun getNoteById(noteId: UUID?): Note? {
        return noteId?.let { noteDataSource.get(it) }
    }
}