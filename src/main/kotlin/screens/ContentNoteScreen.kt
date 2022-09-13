package screens

import InOutUtils
import data.StorageOfNotes
import kotlin.properties.Delegates

class ContentNoteScreen(private val storage: StorageOfNotes): BaseScreen() {
    override var tittleScreen: String = "Просмотр заметки:"
    override val menuList: MutableList<String> = mutableListOf()
    private var targetIdArchive by Delegates.notNull<Int>()
    private var targetIdNote by Delegates.notNull<Int>()

    fun runScreen(idArchive: Int, idNote: Int) {
        targetIdArchive = idArchive
        targetIdNote = idNote
        initData()
        showMenu()
        waitUserCommand()
    }

    private fun initData() {
        menuList.add("Назад")
    }

    override fun showMenu() {
        val note = storage.getArchive(targetIdArchive).noteList[targetIdNote]
        println("======")
        println(tittleScreen)
        println("Заголовок: ${note.tittle} \n" +
                "Содержимое: ${note.textNote}")
        menuList.forEachIndexed { index, command ->
            println("$index. $command")
        }
        println("------")
        print("Введите пункт меню: ")
    }

    private fun waitUserCommand() {
        InOutUtils().readCommand(menuList.size -  1)
        endPrintScreen()
        ArchiveScreen(storage).runScreen(targetIdArchive)
    }
}
