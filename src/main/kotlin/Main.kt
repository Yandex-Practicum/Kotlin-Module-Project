fun main(args: Array<String>) {

    val screen = MainScreen()
    do {
        screen.showMenu()
        if (screen.isExit) break
    } while (true)
}