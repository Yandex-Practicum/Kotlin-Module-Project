import java.util.Scanner
class App {
    private val archivesList = mutableListOf<Archive>()

    fun start() {
        while (true) {
            println("Введите номер действия:")
            println("1. Создать архив")
            println("2. Просмотреть архивы")
            println("0. Назад")

            when (input()) {
                1 -> createArchive()
                2 -> showArchives()
                0 -> return
            }
        }
    }

    private fun input(): Int {
        var scanner = Scanner(System.`in`).nextLine().toIntOrNull()

        while (scanner == null || (scanner != 1 && scanner != 2 && scanner != 0)) {
            println("Некорректный ввод. Введите номер действия, которое хотите совершить")
            scanner = Scanner(System.`in`).nextLine().toIntOrNull()
        }
        return scanner
    }

    private fun createArchive() {
        println("Введите имя архива:")
        var nameArchive = Scanner(System.`in`).nextLine()

        while (nameArchive.isEmpty()) {
            println("Имя архива не может быть пустым")
            nameArchive = Scanner(System.`in`).nextLine()
        }

        archivesList.add(Archive(nameArchive))
        println("Архив '$nameArchive' создан")
    }

    private fun showArchives() {
        if (archivesList.isEmpty()) {
            println("Ещё нет архивов")
            return
        } else {
            while (true) {
                println("Выберите номер архива:")
                archivesList.forEachIndexed { index, archive ->
                    println("${index + 1}. ${archive.nameArchive}")
                }
                println("0. Назад")

                var number = Scanner(System.`in`).nextLine().toIntOrNull()

                while (number == null || number !in 0..archivesList.size) {
                    println("Введите корректный номер")
                    number = Scanner(System.`in`).nextLine().toIntOrNull()
                }

                when (number) {
                    in 1..archivesList.size -> showNotes(archivesList[number - 1])
                    0 -> return
                }
            }
        }
    }

    private fun showNotes(archive: Archive) {

        while (true) {
            println("Введите номер действия:")
            println("1. Создать заметку")
            println("2. Просмотреть заметки")
            println("0. Назад")

            when (input()) {
                1 -> createNote(archive)
                2 -> archive.showNotes()
                0 -> return
            }
        }
    }

    private fun createNote(archive: Archive) {
        println("Введите название заметки:")
        var nameNote = Scanner(System.`in`).nextLine()

        while (nameNote.isEmpty()) {
            println("Это поле не может быть пустым, введите название")
            nameNote = Scanner(System.`in`).nextLine()
        }

        println("Введите текст заметки:")
        var text = Scanner(System.`in`).nextLine()

        while (text.isEmpty()) {
            println("Это поле не может быть пустым, введите название")
            text = Scanner(System.`in`).nextLine()
        }

        archive.addNote(Note(nameNote, text))
        println("Заметка '$nameNote' добавлена в архив '${archive.nameArchive}'")
    }
}

fun main() {
    val app = App()
    app.start()
}