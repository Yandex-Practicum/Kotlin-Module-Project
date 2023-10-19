import java.util.*

val archivesData: MutableList<Archive> = mutableListOf()
val notesData: MutableList<Notes> = mutableListOf()
val menu: Menu = Menu()
val scanner = Scanner(System.`in`)


//Импорт компонентов

fun main(args: Array<String>) { // Создать-Показать список меню
    menu.showListMenu(ArchiveList())
}