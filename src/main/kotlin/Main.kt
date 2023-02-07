import java.util.Scanner

fun main() {
    val archive = ArchiveImpl()
    println(
        "Добро пожаловать в приложение заметки!\n" +
                "Для начала работы введите Start для запуска приложения "
    )
    val sc = Scanner(System.`in`)
    val answer = sc.nextLine()

    while (startStop(answer)) {
        val sca = Scanner(System.`in`)
        val sc = Scanner(System.`in`)
        val sch = Scanner(System.`in`)
        printMenuArh()
        val numberMenu = sca.nextInt()
        when (numberMenu) {
            1 -> println("Введите название архива").apply {
                archive.createArchive(sc.nextLine())
            }
            2 -> archive.printAllArchive()
            3 -> println("Введите название архива").apply {
                archive.removeArchive(sc.nextLine())
            }
            4 -> archive.clearArchive()
            5 -> println("Введите название заметки").apply {
                archive.createNote(sc.nextLine())
            }
            6 -> println("Введите название архива")
                .apply {
                    archive.addNoteToArchive(
                        sc.nextLine()
                            .apply { println("Введите заметку") },
                        archive.createNote(sch.nextLine())
                    )
                }
        }
    }

}

fun printMenuArh() {
    println(
        "1 - Создать архив\n" +
                "2 - Показать все архивы\n" +
                "3 - Удалить один архив\n" +
                "4 - Удалить все архивы\n" +
                "5 - Создать заметку\n" +
                "6 - Добавить заметку к архиву\n" +
                "0 - Выход"
    )
}

fun startStop(str: String): Boolean {
        if (str == "Start") {
            return true
        }
    return false
}


fun app() {
    while (true) {
        println(
            "Добро пожаловать в приложение заметки!\n" +
                    "Для начала работы введите Start для запуска приложения "
        )
    }
}