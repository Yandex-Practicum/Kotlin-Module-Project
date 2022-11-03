import data.Database
import screens.ArchivesListScreen

fun main() {
    println("Привет!")
    val database = Database()
    val archivesListScreen = ArchivesListScreen(database)
    archivesListScreen.start()
}
