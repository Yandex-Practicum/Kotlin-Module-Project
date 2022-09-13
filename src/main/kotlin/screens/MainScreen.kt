package screens

import data.StorageOfNotes

class MainScreen(private var storage: StorageOfNotes?): BaseScreen() {
    override var tittleScreen: String  = "Список архивов:"
    override val menuList: MutableList<String> = mutableListOf()

    fun runScreen() {
        if (storage == null) {
            this.storage = StorageOfNotes()
        }
        initData()
        showMenu()
        waitUserCommand()
    }

    private fun initData() {
        menuList.add("Создать архив")
        storage!!.getArchiveTitle().forEach { archiveTittle ->
            menuList.add(archiveTittle)
        }
        menuList.add("Выход")
    }

    private fun waitUserCommand() {
        val command = utils.readCommand(menuList.size - 1)
        endPrintScreen()
        when(command) {
            0 -> ArchiveCreateScreen(storage!!).runScreen()
            menuList.size - 1 -> {
                println("Завершаем работу программы")
            }
            else -> ArchiveScreen(storage!!).runScreen(command - 1)
        }
    }
}