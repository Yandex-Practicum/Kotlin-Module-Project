package moduls

import java.util.*

class Menu(private val archives: Archives, private val notes: Notes, private val scanner: Scanner) {
    fun showMainMenu() {
        println("Меню:")
        println("1. Выбор архива")
        println("2. Создать архив")
        println("3. Выход")
    }

    fun ArchivesMenu() {
        while (true) {
            println("Список архивов:")
            val archivesList = archives.getArchives()
            archivesList.forEachIndexed { index, archive ->
                println("${index + 1}. $archive")
            }
            val archivesSize = archivesList.size
            println("${archivesSize + 1}. Создать новый архив")
            println("${archivesSize + 2}. Выход")

            try {
                val choice = scanner.nextInt()
                when (choice) {
                    in 1..archivesSize -> NotesMenu(archivesList[choice - 1])
                    archivesSize + 1 -> BildArchive()
                    archivesSize + 2 -> return
                    else -> println("Неверный выбор. Введите число от 1 до ${archivesSize + 2}.")
                }
            } catch (e: Exception) {
                println("Ошибка ввода. Введите число от 1 до ${archivesSize + 2}.")
                scanner.nextLine()
            }
        }
    }

    fun NotesMenu(archive: String) {
        while (true) {
            println("Список заметок в архиве \"$archive\":")
            val noteList = archives.getNotes(archive)
            if (noteList != null) {
                for ((index, note) in noteList.withIndex()) {
                    println("${index + 1}. ${note.first}")
                }
            }
            println("${noteList?.size?.plus(1) ?: 1}. Создать новую заметку")
            println("${noteList?.size?.plus(2) ?: 2}. Выход")

            try {
                val choice = scanner.nextInt()
                val noteListSize = noteList?.size ?: 0

                when (choice) {
                    in 1..noteListSize -> {
                        if (choice <= noteListSize) {
                            notes.NoteDetails(noteList!![choice - 1])
                        } else {
                            println("Неверный выбор. Введите число от 1 до $noteListSize")
                        }
                    }
                    noteListSize + 1 -> BildNote(archive)
                    noteListSize + 2 -> return
                    else -> println("Неверный выбор. Введите число от 1 до ${noteListSize + 2}.")
                }
            } catch (e: Exception) {
                println("Ошибка ввода. Введите число от 1 до ${(noteList?.size ?: 0) + 2}.")
                scanner.nextLine() // Очистить буфер
            }
        }
    }

    fun BildArchive() {
        scanner.nextLine()
        print("Введите название архива: ")
        val archiveName = scanner.nextLine().trim()
        if (archiveName.isNotEmpty()) {
            archives.addArchive(archiveName)
            println("Архив \"$archiveName\" создан.")
        } else {
            println("Название архива не может быть пустым.")
        }
    }

    fun BildNote(archive: String) {
        scanner.nextLine()
        print("Введите название заметки: ")
        val noteName = scanner.nextLine().trim()
        if (noteName.isNotEmpty()) {
            print("Введите текст заметки: ")
            val noteText = scanner.nextLine().trim()
            if (noteText.isNotEmpty()) {
                archives.addNote(archive, noteName, noteText)
                println("Заметка \"$noteName\" создана.")
            } else {
                println("Текст заметки не может быть пустым.")
            }
        } else {
            println("Название заметки не может быть пустым.")
        }
    }
}