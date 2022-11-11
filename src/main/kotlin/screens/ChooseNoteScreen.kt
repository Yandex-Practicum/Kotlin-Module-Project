package screens

import data.DataSource
import model.Note

object ChooseNoteScreen: ChooseScreenAbstract<Note>() {
    override val title = "Меню выбора заметки"
    override val createItemLine = "Создать новую заметку"
    override val createItemOperation = { CreateNoteScreen.start(0) }
    override val chooseItemOperation = { element: Note -> ViewNoteScreen.start(element) }
    override val getElementList = {archiveId: Int -> DataSource.getNotes(archiveId) }
}
