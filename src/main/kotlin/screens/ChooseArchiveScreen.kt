package screens

import data.DataSource
import model.Archive

object ChooseArchiveScreen: ChooseScreenAbstract <Archive>() {
    override val title = "Меню выбора архива"
    override val createItemLine = "Создать новый архив"
    override val createItemOperation = { CreateArchiveScreen.start(0) }
    override val chooseItemOperation = { element: Archive -> ChooseNoteScreen.start(element.id) }
    override val getElementList = { _: Int -> DataSource.getArchives() }
}