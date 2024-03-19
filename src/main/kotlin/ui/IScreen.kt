package ui

interface IScreen {
    val title: String
    fun show()
    fun readCommand(command: () -> Int)
    fun commandHandler(command: Int)
    val onMoveNext: () -> Unit
    val onExit: () -> Unit
}