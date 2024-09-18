import java.util.*
import kotlin.system.exitProcess

class MenuManager {
    private val scanner = Scanner(System.`in`)
    private val archives = mutableListOf<Archive>()

    // Функция для вывода меню выбора архива
    private fun showArchiveMenu() {
        println("Выбор архива:")
        println("0. Создать архив")
        for ((index, archive) in archives.withIndex()) {
            println("${index + 1}. ${archive.title}")
        }
        println("${archives.size + 1}. Выход")

        val choice = readIntInput("Введите номер: ")
        when (choice) {
            0 -> createArchive()

            in  1..archives.size -> showNoteMenu(archives[choice - 1])
            archives.size + 1 -> exitApplication()
            else -> println("Неверный ввод. Попробуйте снова.")
        }
    }


    // Функция для создания нового архива
    private fun createArchive() {
        print("Введите название архива: ")
        val title = scanner.nextLine().trim()
        if (title.isEmpty()) {
            println("Название архива не может быть пустым.")
            return
        }
        else {
            archives.add(Archive(title))
        }
        println("Архив '$title' создан.")
    }

    // Функция для вывода меню выбора заметки
    private fun showNoteMenu(archive: Archive) {
        println("Выбор заметки в архиве '${archive.title}':")
        println("0. Создать заметку")
        for ((index, note) in archive.notes.withIndex()) {
            println("${index + 1}. ${note.title}")
        }
        println("${archive.notes.size + 1}. Назад")

        val choice = readIntInput("Введите номер: ")
        when (choice) {
            0 -> createNote(archive)
            in 1..archive.notes.size -> showNoteDetails(archive.notes[choice - 1])
            archive.notes.size + 1 -> return
            else -> println("Неверный ввод. Попробуйте снова.")
        }
    }

    private   fun showNoteDetails(note: Note) {
        println("Заметка: ${note.title}")
        println(note.text)
        println("Введите 1, чтобы вернуться.")
        scanner.nextInt()
    }

    // Функция для создания новой заметки
    private fun createNote(archive: Archive) {
        print("Введите название заметки: ")
        val title = scanner.nextLine().trim()
        if (title.isEmpty()) {
            println("Название заметки не может быть пустым.")
            return
        }
        print("Введите текст заметки: ")
        val text = scanner.nextLine().trim()
        if (text.isEmpty()) {
            println("Текст заметки не может быть пустым.")
            return
        }
        archive.notes.add(Note(title, text))
        println("Заметка '$title' создана.")



        // Функция для вывода деталей заметки
    }

    // Функция для чтения целочисленного ввода от пользователя
    private fun readIntInput(prompt: String): Int {
        while (true) {
            print(prompt)
            val input = scanner.nextLine()
            if (input.matches(Regex("\\d+"))) {
                return input.toInt()
            } else {
                println("Неверный ввод. Введите число.")
            }
        }
    }
    fun exitApplication() {
        println("Завершение программы.")
        exitProcess(0) // 0 - код завершения, указывающий на успешное завершение
    }
    // Функция для запуска приложения
    fun run() {
        while (true) {
            showArchiveMenu()
        }
    }
}


