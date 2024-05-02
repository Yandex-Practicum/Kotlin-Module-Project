fun main() {
    val archives = mutableListOf<Archive>()
    val menu = ArchiveMenu(archives)
    while (true) {
        menu.show()
        val input = readLine()!!
        menu.handleInput(input)
    }
}