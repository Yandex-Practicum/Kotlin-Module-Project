class NotePage: Page<Note>("Создать", "Выполнение команд с записями", mutableListOf(), -1) {
    override fun execElementCommand(commandNumber: Int) {
        super.command = "Показать"
        super.action()
        super.command = "Создать"
    }

    override fun execCreateCommand(input: String) {
        super.mutableList.add(Note(input))
    }
}