import java.util.Scanner



object NotesApp {
    private val archives = mutableListOf<Archive>()
    private val scanner = Scanner(System.`in`)

    private fun addArchive(archive: Archive) {
        archives.add(archive)
    }

    private fun createArchive() {
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

    private fun selectArchiveMenu() {
        while (true) {
            println("Список архивов:")
            println("0. Создать новый архив")
            archives.forEachIndexed { index, archive ->
                println("${index + 1}. ${archive.name}")
            }

            println("${archives.size + 1}. Выход")
            println("Выберите архив (введите номер или 0 для создания нового, ${archives.size + 1} для выхода):")
            val input = scanner.nextLine()

            when {
                input == "0" -> {
                    createArchive()
                }
                input == "${archives.size + 1}" -> {
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

    private fun selectNoteMenu(archive: Archive){
        while (true) {
            println("Архив: ${archive.name}")
            println("Список заметок:")
            val lastNoteIndex = archive.notes.size  // Определяем номер последней заметки
            println("0. Создать новую заметку")
            archive.notes.forEachIndexed { index, note ->
                println("${index + 1}. ${note.title}")
            }
            println("${lastNoteIndex + 1}. Вернуться к выбору архива")  // Используем последний номер заметки
            println("Выберите заметку (введите номер, 0 для создания новой или ${lastNoteIndex + 1} для возврата):")
            val input = scanner.nextLine()

            when {
                input == "0" -> {
                    createNote(archive)
                }
                input == "${lastNoteIndex + 1}" -> {
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
                    println("Некорректный ввод. Введите номер заметки, 0 для создания новой или ${lastNoteIndex + 1} для возврата.")
                }
            }
        }
    }

    private fun createNote(archive: Archive) {
        println("Введите заголовок новой заметки (или введите 2 для отмены):")
        val noteTitle = scanner.nextLine()
        when {
            noteTitle == "2" -> {
                println("Создание заметки отменено.")
                return
            }
            noteTitle.isNotBlank() -> {
                println("Введите содержимое новой заметки:")
                val noteContent = scanner.nextLine()
                val newNote = Note(noteTitle, noteContent)
                archive.addNote(newNote)
                println("Заметка \"$noteTitle\" добавлена в архив.")
            }
            else -> {
                println("Заголовок заметки не может быть пустым.")
            }
        }
    }

    private fun viewNoteContent(note: Note) {
        println("Содержимое заметки:")
        println("Заголовок: ${note.title}")
        println("Содержание: ${note.content}")
    }

    @JvmStatic
    fun main(args: Array<String>) {
        selectArchiveMenu()
    }
}