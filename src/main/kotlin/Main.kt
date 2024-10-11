fun main() {
    val archives = mutableListOf<Archive>()
    val ioHandler = IOHandler()
    val mainMenu = MainMenu(archives, ioHandler)
    ioHandler.showMessage("Добро пожаловать в программу!\n")
    mainMenu.show()
}