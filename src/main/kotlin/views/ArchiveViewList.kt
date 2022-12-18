package views

import data.Archive

class ArchiveViewList(var archive: MutableList<Archive>) : View() {
    override var viewName = "Экран списка архивов"
    override var navigateText = "Выходим из приложения."
    override var commandNumbers = archive.size + 1

    override fun createCommands(): MutableList<Pair<String, () -> Unit>> {
        val commandList = mutableListOf<Pair<String, () -> Unit>>()
        commandList.add(
            Pair(
                "0. Перейти к экрану созданию архивов.",
                ArchiveCreationView(archive).commandReader()
            )
        )
        for (index in 0 until archive.size) {
            commandList.add(
                Pair(
                    "${index + 1}. ${archive[index].name}",
                    NoteViewList(archive[index].notesList).commandReader()
                )
            )
        }
        commandList.add(Pair("${archive.size + 1}. Выходим из приложения.", exit()))
        return commandList
    }
}