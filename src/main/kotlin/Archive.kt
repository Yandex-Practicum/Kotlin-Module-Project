import jdk.nashorn.internal.objects.Global.println
import java.util.*

class Archive {
    var name = ""
    private val noteList = ArrayList<String>()
    private val scanner = Scanner(System.`in`)

    fun createArchive(): Boolean {
        println("\nВведите название архива:")
        name = scanner.nextLine()
        return if (name.isNotBlank()) {
            println("Архив '$name' создан.")
            true
        } else {
            println("Имя архива не может быть пустым.")
            false
        }
    }

    fun openArchive() {
        while (true) {
            println("\n1. Добавить заметку\n2. Просмотреть заметки\n3. Вернуться к списку архивов")
            val userInput = scanner.nextLine()
            when {
                userInput == "1" -> addNote()
                userInput == "2" -> {
                    if (noteList.size > 0) viewNotes() else println("В архиве нет заметок.")
                }
                userInput == "3" -> return
                else -> println("Неверный ввод, попробуйте снова.")
            }
        }
    }

    private fun addNote() {
        println("\nВведите текст заметки:")
        val note = scanner.nextLine()
        if (note.isNotBlank()) {
            noteList.add(note)
            println("Заметка добавлена в архив '$name'.")
        } else {
            println("Заметка не может быть пустой.")
        }
    }

    private fun viewNotes() {
        println("\nЗаметки в архиве '$name':")
        for (i in 0 until noteList.size) {
            println("${i + 1}. ${noteList[i]}")
        }
    }
}
