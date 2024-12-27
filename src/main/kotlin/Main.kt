import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    val archiveManager = ArchiveManager()

    while (true) {
        println("Главное меню:")
        println("1. Выбрать архив")
        println("2. Создать архив")
        println("3. Выход")
        print("Введите номер пункта: ")

        when (scanner.nextLine()) {
            "1" -> archiveManager.showArchivesMenu()
            "2" -> archiveManager.createArchive()
            "3" -> {
                println("Выход из программы.")
                break
            }
            else -> println("Некорректный ввод. Попробуйте снова.")
        }
    }
}
