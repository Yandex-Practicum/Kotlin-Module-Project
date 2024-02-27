import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    val archives = Archives()
    val notes = Notes()
    val menu = Menu(archives, notes, scanner)

    while (true) {
        menu.showMainMenu()

        try {
            when (scanner.nextInt()) {
                1 -> menu.ArchivesMenu()
                2 -> menu.BildArchive()
                3 -> return
                else -> println("Неверный выбор. Введите число от 1 до 3.")
            }
        } catch (e: Exception) {
            println("Ошибка ввода. Введите число от 1 до 3.")
            scanner.nextLine()
        }
    }
}




