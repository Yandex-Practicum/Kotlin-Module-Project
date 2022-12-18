package views

import data.Note

class NoteViewList(private val noteList: MutableList<Note>) : View() {
    override var viewName = "Экран списка заметок"
    override var navigateText = "Возвращаемся к списку архивов."
    override var commandNumbers = noteList.size + 1

    override fun createCommands(): MutableList<Pair<String, () -> Unit>> {
        val commandList = mutableListOf<Pair<String, () -> Unit>>()
        commandList.add(
            Pair("0. Перейти к экрану созданию заметок.", NoteCreationView(noteList).commandReader()))
        for (note in 0 until noteList.size) {
            commandList.add(Pair("${note + 1}. ${noteList[note].name}", NoteView(noteList[note]).commandReader()))
        }
        commandList.add(Pair("${noteList.size + 1}. Вернуться к экрану списка архивов.", exit()))
        return commandList
    }
}