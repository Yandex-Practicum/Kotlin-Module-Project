class StartScreen(val ud: UserDialogue) {
    private var archivesList = mutableListOf<Archive>()

    fun open() {
        showMenu(archivesList)
    }

    private fun addArchive() {
        val newArchiveName = ud.getAnswer("Введите название архива")
        archivesList.add(Archive(newArchiveName))
        showMenu(archivesList)
    }

    private fun openArchive(archive: Archive, position: Int) {
        val archiveScreen = ArchiveScreen(ud, archive)
        val newArchive = archiveScreen.open()
        if (newArchive != null)
            archivesList[position] = newArchive
        showMenu(archivesList)
    }

    private fun showMenu(commands: List<Archive>) {
        println("Список архивов:")
        val currentCommands: List<Pair<String, () -> Unit>> = getCommands(commands)
        ud.chooseCommand(currentCommands)
    }

    private fun getCommands(commands: List<Archive>): List<Pair<String, () -> Unit>> {
        var commandList: MutableList<Pair<String, () -> Unit>> =
            mutableListOf(Pair("0 - Создать архив", { -> addArchive() }))
        commands.forEachIndexed { index, element ->
            commandList.add(
                Pair(
                    "${index + 1} - ${element.name}",
                    { -> openArchive(element, index) })
            )
        }
        commandList.add(Pair("${commandList.size} - Выход", { -> exit() }))
        return commandList
    }

    private fun exit() {
        println("Работа программы завершена")
    }
}