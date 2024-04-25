import java.util.Scanner

class Archive(val name: String) {
    companion object {
        private val scanner = Scanner(System.`in`)
        val notes = mutableListOf<Note>()
        fun addNote(note: Note) {
            notes.add(note)
        }

        private fun addArchive(archive: Archive) {
            NotesApp.archives.add(archive)
        }

        private fun createArchive() {
            println("Введите название нового архива:")
            val archiveName = scanner.nextLine()
            when {
                archiveName == "2" -> {
                    println("Выход")
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

        fun archiveMenu() {
            while (true) {
                println("Список архивов:")
                println("0. Создать новый архив")
                NotesApp.archives.forEachIndexed { index, archive ->
                    println("${index + 1}. ${archive.name}")
                }
                println("${NotesApp.archives.size + 1}. Выход")
                println("Выберите архив (введите номер или 0 для создания нового, ${NotesApp.archives.size + 1} для выхода):")
                val input = scanner.nextLine()

                when {
                    input == "0" -> {
                        createArchive()
                    }

                    input == "${NotesApp.archives.size + 1}" -> {
                        println("Выход из программы.")
                        return
                    }

                    input.toIntOrNull() != null -> {
                        val archiveIndex = input.toInt()
                        if (archiveIndex in 1..NotesApp.archives.size) {
                            Note.noteMenu(NotesApp.archives[archiveIndex - 1])
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
    }

}