import java.util.*

val archivesData: MutableList<Archive> = mutableListOf()
val notesData: MutableList<Notes> = mutableListOf()
val menu: Menu = Menu()
val scanner = Scanner(System.`in`)


fun main() {
    menu.showListMenu(ArchiveList())
    scanner.close()
}