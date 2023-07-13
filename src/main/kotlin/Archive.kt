import jdk.nashorn.internal.objects.Global.println
import java.util.*

class Archive {
    var name = ""
    private val noteList = ArrayList<String>()
    private val scanner = Scanner(System.`in`)

    fun createArchive() {
        println("\nВведите название архива:")
        name = scanner.nextLine()
        println("Архив '$name' создан.")
    }

    fun openArchive() {
        while (true) {
            println("\n1. Добавить заметку\n2. Просмотреть заметки\n3. Вернуться к списку архивов")
            val userInput = scanner.nextLine()
            when {
                userInput.equals("1") -> addNote()
                userInput.equals("2") -> {
                    if (noteList.size > 0) viewNotes() else println("В архиве нет заметок.")
                }
                userInput.equals("3") -> return
                else -> println("Неверный ввод, попробуйте снова.")
            }
        }
    }

    private fun addNote() {
        println("\nВведите текст заметки:")
        val note = scanner.nextLine()
        noteList.add(note)
        println("Заметка добавлена в архив '$name'.")
    }

    private fun viewNotes() {
        println("\nЗаметки в архиве '$name':")
        for (i in 0..noteList.size - 1) {
            println("${i + 1}. ${noteList[i]}")
        }
    }
}



