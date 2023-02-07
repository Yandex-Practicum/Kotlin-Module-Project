import java.util.Scanner

fun main() {

    val sc = Scanner(System.`in`)
    val answer = sc.nextLine()

    while (startStop(answer)) {
        val archive = ArchiveImpl()
        val sca = Scanner(System.`in`)
        val scannerArchiveTittle = Scanner(System.`in`)
        val scannerNote = Scanner(System.`in`)
        printMenuArh()
        val numberMenu = sca.nextInt()

        when (numberMenu) {
            1 -> println("Введите название архива").apply {
                archive.createArchive(scannerArchiveTittle.nextLine())
            }
            2 -> archive.printAllArchive()

            3 -> println("Введите название архива").apply {
                archive.removeArchive(scannerArchiveTittle.nextLine())
            }
            4 -> archive.clearArchive()

            5 -> println("Введите название заметки").apply {
                archive.createNote(scannerNote.nextLine())
            }
            6 -> println("Введите название архива")
                .apply {
                    archive.addNoteToArchive(
                        scannerArchiveTittle.nextLine()
                            .apply { println("Введите заметку") },
                        archive.createNote(scannerNote.nextLine())
                    )
                }
            7 -> archive.printAllNote()
            0 -> break
        }
    }

}

private fun printMenuArh() {
    println(
        "1 - Создать архив\n" +
                "2 - Показать все архивы\n" +
                "3 - Удалить один архив\n" +
                "4 - Удалить все архивы\n" +
                "5 - Создать заметку\n" +
                "6 - Добавить заметку к архиву\n" +
                "7 - Показать все заметки\n" +
                "0 - Выход"
    )
}
private fun startStop(str: String): Boolean {
    if (str == "Start") {
        return true
    }
    return false
}
