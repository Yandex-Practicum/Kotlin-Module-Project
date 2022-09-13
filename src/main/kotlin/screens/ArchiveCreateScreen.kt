package screens

import InOutUtils
import data.StorageOfNotes
import data.model.Archive

class ArchiveCreateScreen (private val storage: StorageOfNotes): BaseScreen(){
    override var tittleScreen = "Создание нового архива:"
    override val menuList: MutableList<String> = mutableListOf()

    private lateinit var tittleArchive: String

    fun runScreen() {
        showMenu()
        waitUserCommand()
        storage.addArchive(Archive(title = tittleArchive, mutableListOf()))
        endPrintScreen()
        MainScreen(storage).runScreen()
    }

    override fun showMenu() {
        println("======")
        println(tittleScreen)
        println("------")
        print("Введите название архива: ")
    }

    private fun waitUserCommand() {
        tittleArchive = InOutUtils().readString()
    }
}