import java.util.Scanner

data class Note(val title: String, val content: String)

data class Archive(val name: String) {
    val notes = mutableListOf<Note>()
}

fun main() {
    val mainMenu = ArchiveMenu()
    mainMenu.show()
}