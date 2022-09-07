import java.util.*
import kotlin.collections.ArrayList

class PrintNoteUtils
    (
    private val note: Note
    ) {
    init {
        val scanner = Scanner(System.`in`)
        note.printFullNote()
        println("")
        println("Напишите 0, чтобы вернуться к списку заметок:")
        var isInputOk: Boolean = false

        while(!isInputOk) {
            val userInput: Int? = scanner.nextLine().toIntOrNull()
            if (userInput != null) {
                if (userInput == 0) {
                    isInputOk = true
                } else {
                    println("Действия с таким номером не существует, введите число 0")
                }
            } else {
                println("Пожалуйста, введите число 0")
            }
        }
    }
}