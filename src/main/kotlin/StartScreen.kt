var archivesList = mutableListOf<Archive>()

fun openStartScreen() {
    showStartScreenMenu(archivesList)
}

fun updateArchivesList(position: Int, newArchive: Archive) {
    archivesList[position] = newArchive
}

fun addArchive() {
    val newArchiveName = getAnswer("Введите название архива")
    archivesList.add(Archive(newArchiveName))
    showStartScreenMenu(archivesList)
}

fun showStartScreenMenu(commands: List<Archive>) {
    println("Список архивов:")
    val currentCommands: List<Pair<String, () -> Unit>> = getStartScreenCommands(commands)
    chooseCommand(currentCommands)
}

fun getStartScreenCommands(commands: List<Archive>): List<Pair<String, () -> Unit>>{
    var commandList: MutableList<Pair<String, () -> Unit>> = mutableListOf(Pair("0 - Создать архив", { -> addArchive() }))
    commands.forEachIndexed { index, element -> commandList.add(Pair("${index + 1} - ${element.name}", { -> openArchiveScreen(element, index) })) }
    commandList.add(Pair("${commandList.size} - Выход", { -> exit() }))
    return commandList
}

fun exit() {
    println("Работа программы завершена")
}