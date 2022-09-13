package screens

import InOutUtils
import data.StorageOfNotes
import data.model.Archive
import kotlin.properties.Delegates

class ArchiveScreen(private val storage: StorageOfNotes): BaseScreen() {
    override var tittleScreen: String = "Список заметок в архиве [%s]:"
    override val menuList: MutableList<String> = mutableListOf()

    private var targetArchive: Archive? = null
    private var targetIdArchive by Delegates.notNull<Int>()


    fun runScreen(archiveKey: Int) {
        initData(archiveKey)
        showMenu()
        waitUserCommand()
    }

    private fun initData(archiveKey: Int) {
        targetIdArchive = archiveKey
        targetArchive = storage.getArchive(archiveKey)
        tittleScreen = String.format(tittleScreen, targetArchive?.title)
        menuList.add("Создать заметку")
        targetArchive!!.noteList.forEach {note ->
            menuList.add(note.tittle)
        }
        menuList.add("Назад")
    }


    private fun waitUserCommand() {
        val command = InOutUtils().readCommand(menuList.size - 1)

        endPrintScreen()
        when(command) {
            0 -> NoteCreateScreen(storage).runScreen(targetIdArchive)
            menuList.size - 1 -> MainScreen(storage).runScreen()
            else -> ContentNoteScreen(storage).runScreen(targetIdArchive, command - 1)
        }
    }
}