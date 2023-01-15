fun main() {
    ArchivesMainMenu.printMenu()
}

fun exit() {
    return
}

fun String.isValidInt(): Boolean {
    return this.toIntOrNull() != null
}

