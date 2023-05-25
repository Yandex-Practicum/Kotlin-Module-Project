class MenuViewNote (val key: Int, val text: String) : CreateInterface {
    override val title = "Введите 1 для выхода"
    override var tempData = ""
    override val backToMenu: () -> Unit = {menu.showViewMenu(MenuViewArchive(key))}

    override fun createFromInput() {
        do {
            println("Текст заметки:")
            println(text)
            println("")
            println(title)
            tempData = menu.getUserInput()
        } while (tempData != "1")
        backToMenu.invoke()
    }



}