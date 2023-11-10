class CreateArchive () : CreateInterface {
    override val title = "Введите имя архива"
    override var nameArchive = ""
    override val backMenu = {menu.showViewMenu(MenuArchiveCollection())}

    override fun createFromInput() {
        println(title)
        nameArchive = menu.getUserInput()
        if (nameArchive.isEmpty()) {
            println("Ошибка! Имя архива не может быть пустым")
            backMenu.invoke() }
        NoteArchiveCollection.addToCollection(nameArchive)
        println("Создан архив с именем: $nameArchive")
        backMenu.invoke()
    }

}