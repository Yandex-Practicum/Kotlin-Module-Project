import java.util.*

val archivesData: MutableList<Archive> = mutableListOf()
val notesData: MutableList<Notes> = mutableListOf()
val menu: Menu = Menu()
val scanner = Scanner(System.`in`)


fun main(args: Array<String>) {
    menu.showListMenu(ArchiveList())
    scanner.close()
}