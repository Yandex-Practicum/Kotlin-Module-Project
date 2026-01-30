import models.Archive
import ui.ArchiveMenu
fun main() {
    println("=== Приложение \"Заметки\" ===")

    val archives = mutableListOf<Archive>()
    val archiveMenu = ArchiveMenu(archives)

    archiveMenu.show()

    println("До свидания!")
}