fun main() {
    val archiveManager = ArchiveManager()
    val stack = mutableListOf<Menu>()
    val helper = MenuScanner()
    val createArchiveMenu = CreateArchiveMenu(stack, archiveManager, helper)
    println("\nДобро пожаловать в приложение, в котором вы можете создавать заметки и помещать их в архивы.\n")
    stack.add(createArchiveMenu)
    createArchiveMenu.showMenu()
}