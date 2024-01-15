import java.util.Scanner

class Note(val text: String)

class Archive(val name: String) {
    val notes = mutableListOf<Note>()
    fun addNote(note: Note) {
        notes.add(note)
    }
}

object NotesApp {
    val archives = mutableListOf<Archive>()
    val scanner = Scanner(System.`in`)

    fun addArchive(archive: Archive) {
        archives.add(archive)
    }

    fun createArchive() {
        println("Введите название нового архива (или введите 2 для отмены):")
        val archiveName = scanner.nextLine()
        when {
            archiveName == "2" -> {
                println("Создание архива отменено.")
                return
            }
            archiveName.isNotBlank() -> {
                val newArchive = Archive(archiveName)
                addArchive(newArchive)
                println("Архив \"$archiveName\" создан.")
            }
            else -> {
                println("Название архива не может быть пустым.")
            }
        }
    }

    fun selectArchiveMenu() {
        while (true) {
            println("Список архивов:")
            archives.forEachIndexed { index, archive ->
                println("${index + 1}. ${archive.name}")
            }
            println("0. Создать новый архив")
            println("2. Выход")
            println("Выберите архив (введите номер или 0 для создания нового, 2 для выхода):")
            val input = scanner.nextLine()

            when {
                input == "0" -> {
                    createArchive()
                }
                input == "2" -> {
                    println("Выход из программы.")
                    return
                }
                input.toIntOrNull() != null -> {
                    val archiveIndex = input.toInt()
                    if (archiveIndex in 1..archives.size) {
                        selectNoteMenu(archives[archiveIndex - 1])
                    } else {
                        println("Такого номера архива нет.")
                    }
                }
                else -> {
                    println("Некорректный ввод. Введите номер архива, 0 для создания нового или 2 для выхода.")
                }
            }
        }
    }

    fun selectNoteMenu(archive: Archive) {
        while (true) {
            println("Архив: ${archive.name}")
            println("Список заметок:")
            archive.notes.forEachIndexed { index, note ->
                println("${index + 1}. ${note.text}")
            }
            println("0. Создать новую заметку")
            println("2. Вернуться к выбору архива")
            println("Выберите заметку (введите номер, 0 для создания новой или 2 для выхода):")
            val input = scanner.nextLine()

            when {
                input == "0" -> {
                    createNote(archive)
                }
                input == "2" -> {
                    println("Возврат к выбору архива.")
                    return
                }
                input.toIntOrNull() != null -> {
                    val noteIndex = input.toInt()
                    if (noteIndex in 1..archive.notes.size) {
                        viewNoteContent(archive.notes[noteIndex - 1])
                    } else {
                        println("Такой заметки в архиве нет.")
                    }
                }
                else -> {
                    println("Некорректный ввод. Введите номер заметки, 0 для создания новой или 2 для возврата.")
                }
            }
        }
    }

    fun createNote(archive: Archive) {
        println("Введите текст новой заметки (или введите 2 для отмены):")
        val noteText = scanner.nextLine()
        when {
            noteText == "2" -> {
                println("Создание заметки отменено.")
                return
            }
            noteText.isNotBlank() -> {
                val newNote = Note(noteText)
                archive.addNote(newNote)
                println("Заметка \"$noteText\" добавлена в архив.")
            }
            else -> {
                println("Текст заметки не может быть пустым.")
            }
        }
    }

    fun viewNoteContent(note: Note) {
        println("Содержимое заметки:")
        println(note.text)
    }

    @JvmStatic
    fun main(args: Array<String>) {
        selectArchiveMenu()
    }
}