class MenuViewNote (val key: Int, val text: String) : CreateInterface {
    override val title = "Введите 1 для выхода"
    override var nameArchive = ""
    override val backMenu: () -> Unit = {menu.showViewMenu(MenuArchive(key))}

    override fun createFromInput() {
        do {
            println("Текст заметки:")
            println(text)
            println("")
            println(title)
            nameArchive = menu.getUserInput()
        } while (nameArchive != "1")
        backMenu.invoke()
    }
}