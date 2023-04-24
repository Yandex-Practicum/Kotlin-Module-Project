import kotlin.system.exitProcess

fun main() {
    NotesController().mainScreen()
}

class NotesController() {

    private val newStorage = Storage()

    fun mainScreen() {
        println("Список экранов: \n 0. Создать архив \n 1. Созданный архив \n 2. Выход \n")
        while (true) {
            println("Введите число: ")
            when (readLine()?.toIntOrNull()) {
                0 -> {
                    println("Введите название Архива: ")
                    newStorage.addArchive(Archive(readLine() ?: ""))
                }
                1 -> {
                    newStorage.showArchives()
                    archiveChoose()
                }
                2 -> exitProcess(-1)
            }
        }
    }

    fun archiveChoose() {
        println("1. Открыть Архив 2. Вернуться \n")
        while (true) {
            println("Введите число: ")
            when (readLine()?.toIntOrNull()) {
                1 -> {
                    println("Введите название Архива: ")
                    val chooseArchive = newStorage.findArchive(readlnOrNull() ?: "")
                    if (chooseArchive != null) {
                        showArchive(chooseArchive)
                    } else {
                        println("Ошибка!\n")
                    }
                }
                2 -> {
                    mainScreen()
                }
                else -> println("Ошибка!")
            }
        }
    }

    fun showArchive(archive: Archive) {
        println("Список экранов: \n 0. Создать заметку \n 1. Созданные заметки \n 2. Вернуться \n")
        while (true) {
            println("Введите число: ")
            when (readLine()?.toIntOrNull()) {
                0 -> {
                    println("Введите название Заметки: ")
                    val name = readlnOrNull() ?: ""
                    println("Введите тело Заметки: ")
                    val body = readlnOrNull() ?: ""
                    archive.addNote(Note(name,body))
                }

                1 -> {
                    choiceNote(archive)
                }

                2 -> {
                    archiveChoose()
                }
            }
        }
    }

    fun choiceNote(archive: Archive) {
        while (true) {
            archive.showNotes()
            println("1. Открыть заметку 2. Вернуться \n")
            println("Введите число: ")
            when (readLine()?.toIntOrNull()) {
                1 -> {
                    println("Введите название Заметки: ")
                    val chosenNote = archive.findNote(readlnOrNull() ?: "")
                    if (chosenNote != null) {
                        println("Заметка: ${chosenNote.body} \n")
                    } else {
                        println("Ошибка!\n")
                    }
                }
                2 -> {
                    showArchive(archive)
                }
            }
        }
    }
}