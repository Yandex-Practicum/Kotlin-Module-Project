package menus

import models.Archive
import java.util.*

fun createArchiveMenu(archives: MutableList<Archive>, scanner: Scanner) {
    println("\nВведите название архива (можно оставить пустым):")
    val name = scanner.nextLine().trim()
    archives.add(Archive(name))
    println("Архив добавлен!")
}
