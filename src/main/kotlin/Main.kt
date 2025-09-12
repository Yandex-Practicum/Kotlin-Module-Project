import java.util.Scanner

data class Note(val text: String)
data class Archive(val name: String, val notes: MutableList<Note> = mutableListOf())

fun main() {
    val scanner = Scanner(System.`in`)
    val archives = mutableListOf<Archive>()

    fun inputNumber(limit: Int): Int {
        while (true) {
            val input = scanner.nextLine()
            val num = input.toIntOrNull()
            if (num == null) {
                println("Ошибка: введите цифру.")
            } else if (num !in 0 until limit) {
                println("Ошибка: такого пункта нет.")
            } else {
                return num
            }
            print("Повторите ввод: ")
        }
    }

    fun viewNoteMenu(note: Note) {
        while (true) {
            println("\n--- Просмотр заметки ---")
            println(note.text)
            println("0. Назад")

            when (inputNumber(1)) {
                0 -> return
            }
        }
    }

    fun createNoteMenu(archive: Archive) {
        println("\nВведите текст новой заметки:")
        val text = scanner.nextLine()
        archive.notes.add(Note(text))
        println("Заметка добавлена!")
    }

    fun notesMenu(archive: Archive) {
        while (true) {
            println("\n--- Архив: ${archive.name} ---")
            println("0. Создать заметку")
            archive.notes.forEachIndexed { i, note ->
                println("${i + 1}. ${note.text.take(20)}...")
            }
            println("${archive.notes.size + 1}. Назад")

            val choice = inputNumber(archive.notes.size + 2)
            when (choice) {
                0 -> createNoteMenu(archive)
                in 1..archive.notes.size -> viewNoteMenu(archive.notes[choice - 1])
                archive.notes.size + 1 -> return
            }
        }
    }

    fun createArchiveMenu() {
        println("\nВведите название архива:")
        val name = scanner.nextLine()
        archives.add(Archive(name))
        println("Архив добавлен!")
    }

    fun archivesMenu() {
        while (true) {
            println("\n--- Список архивов ---")
            println("0. Создать архив")
            archives.forEachIndexed { i, archive ->
                println("${i + 1}. ${archive.name}")
            }
            println("${archives.size + 1}. Выход из программы")

            val choice = inputNumber(archives.size + 2)
            when (choice) {
                0 -> createArchiveMenu()
                in 1..archives.size -> notesMenu(archives[choice - 1])
                archives.size + 1 -> {
                    println("Выход из программы...")
                    return
                }
            }
        }
    }

    println("=== Программа Заметки ===")
    archivesMenu()
}
