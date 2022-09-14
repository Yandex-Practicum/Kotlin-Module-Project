package main.kotlin.application.ui


import main.kotlin.application.datasource.ArchiveDataSource
import main.kotlin.application.datasource.NoteDataSource
import main.kotlin.application.model.Note
import main.kotlin.framework.navigation.Navigation
import main.kotlin.framework.ui.UWidget
import main.kotlin.framework.ui.Ui
import java.util.*


class NoteListScreen(navigation: Navigation, private val archiveID: UUID) : UWidget(navigation) {

    private val archiveDataSource = ArchiveDataSource
    private val noteDataSource = NoteDataSource
    private var currentListOfNotes = getListNotesById(archiveID)

    override var ui: Ui = Ui(
        header = "Note List",
        body = currentListOfNotes.map { it.note } + "New" + "EXIT"
    )

    override fun start() {
        super.start()
        inputChecker(currentListOfNotes.map { it.note } + "New" + "Exit") {
            onMenuItemReceived(it)
        }
    }

    override fun reDraw() {
        currentListOfNotes = getListNotesById(archiveID)
        val uiList = currentListOfNotes.map { it.note } + "New" + "Exit"
        ui = ui.copy(body = uiList)
        ui.draw()
        inputChecker(uiList) {
            onMenuItemReceived(it)
        }
    }

    private fun onMenuItemReceived(it: Int) {
        when (it) {
            in currentListOfNotes.indices -> navigation.navigate(NoteNewEditScreen(navigation, archiveID, currentListOfNotes[it].id))
            currentListOfNotes.size -> navigation.navigate(NoteNewEditScreen(navigation, archiveID))
            currentListOfNotes.size + 1 -> destroy()
        }
    }

    private fun getListNotesById(archiveId: UUID): List<Note> {
        return archiveDataSource.get(archiveId)?.listOfNotes?.mapNotNull { noteDataSource.get(it) } ?: emptyList()
    }

}