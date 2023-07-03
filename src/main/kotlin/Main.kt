import java.util.Scanner

class Note(val nameNote: String, val textNote: String)

class Archive(val nameArchive: String, val notes: MutableList<Note>)

class FunctionsAppNotes {
    val archives = mutableListOf<Archive>()

    fun addArchive(name: String) {
        archives.add(Archive(name, mutableListOf()))
    }

    fun addNoteToArchive(numberArchive: Int, nameNote: String, textNote: String) {
        archives[numberArchive].notes.add(Note(nameNote, textNote))
    }

    fun getArhives(): List<String> {
        return archives.map { it.nameArchive }
    }

    fun getNote(numberArchive: Int): List<String> {
        return archives[numberArchive].notes.map { it.nameNote }
    }

    fun getTextNote(numberArchive: Int, numberNote: Int): String {
        return archives[numberArchive].notes[numberNote].textNote
    }
}

fun main() {
    val appNotes = FunctionsAppNotes()
    val scanner = Scanner(System.`in`)
    while (true) {
        println("1. Создать архив")
        println("2. Список архивов")
        println("3. Выход")
        val choice = scanner.nextInt()

        when (choice) {
            1 -> {
                println("Введите название архива:")
                val nameArch = scanner.next()
                appNotes.addArchive(nameArch)
            }
            2 -> {
                while (true) {
                    println("Список архивов:")
                    val archives = appNotes.getArhives()
                    for (i in archives.indices) {
                        println("$i. ${archives[i]}")
                    }
                    println("${archives.size}. Назад")
                    val archiveChoise = scanner.nextInt()

                    when {
                        archiveChoise < archives.size -> {
                            val archiveName = archives[archiveChoise]
                            while (true) {
                                println("Список заметок в архиве: $archiveName")
                                val notes = appNotes.getNote(archiveChoise)
                                for (i in notes.indices) {
                                    println("$i. ${notes[i]}")
                                }
                                println("${notes.size}. Создать заметку")
                                println("${notes.size + 1}. Назад")
                                val noteChoice = scanner.nextInt()

                                when {
                                    noteChoice == notes.size -> {
                                        println("Введите название заметки:")
                                        val nameNote = scanner.next()
                                        println("Введите текст заметки:")
                                        val textNote = scanner.next()
                                        appNotes.addNoteToArchive(noteChoice, nameNote, textNote)
                                    }
                                    noteChoice == notes.size + 1 -> {
                                        break
                                    }
                                    noteChoice < notes.size -> {
                                        val nameNote = notes[noteChoice]
                                        val textNote =
                                            appNotes.getTextNote(archiveChoise, noteChoice)
                                        println("Заметка '$nameNote': $textNote")
                                    }

                                    else -> println("Неверный выбор")
                                }
                            }
                        }
                        archiveChoise == archives.size -> {
                            break
                        }
                        else -> println("Неверный выбор")
                    }
                }
            }
            3 -> break

            else -> println("Неверный выбор")
        }
    }
}