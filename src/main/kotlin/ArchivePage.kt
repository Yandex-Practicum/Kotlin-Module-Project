class ArchivePage: Page<Archive>("Создать", "Выполнение команд с архивами", mutableListOf(), -1) {
    override fun execCreateCommand(input: String) {
        super.mutableList.add(Archive(input, mutableListOf()))
    }

    override fun execElementCommand(commandNumber: Int) {
        val notesPage = NotePage()
        notesPage.command = "Создать"
        notesPage.mutableList = super.mutableList.elementAt(commandNumber).getNotes()
        notesPage.action()
    }
}