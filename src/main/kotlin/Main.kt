import java.util.*

fun main() {

val scanner = Scanner(System.`in`)
val archiveManager = ArchiveManager()
val utils = Utils()

while (true) {
    val archives = archiveManager.getArchives()

    println("Список архивов:")
    println("0. Создать архив")
    archives.forEachIndexed { index, archive -> println("${index + 1}. ${archive.name}") }
    println("${archives.size + 1}. Выход")

    val input = scanner.nextLine()

    if (utils.validateInput(input)) {
        val number = input.toIntOrNull()
        if (number == null) {
            utils.viewDigitError()
        }
        else {
            when (number) {
                0 -> {
                    println("Введите название архива:")
                    val archiveName = scanner.nextLine()
                    archiveManager.createArchive(archiveName)
                    println("Архив создан.")
                }

                in 1..archives.size -> {
                    archives[number - 1].showNotesMenu(scanner)
                }

                archives.size + 1 -> {
                    println("До новых встреч!")
                    return
                }
                else -> utils.viewDigitError()
            }
        }
    }
}
}