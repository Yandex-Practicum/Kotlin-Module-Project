import java.util.*
import kotlin.collections.ArrayList

class PrintNoteListUtils
    <T>(
    private val title: String,
    private val firstItemText: String,
    private val list: MutableList<T>,
    private val currentArchive: Archive
    ) {
    init {
        val scanner = Scanner(System.`in`)
        println(title)
        println("0. Создать $firstItemText")

        list.forEachIndexed { i, item -> println("${i + 1} $item") }
        println("${list.size + 1} Выход")
        println("Выберите действие, введя номер пункта:")
        var isInputOk: Boolean = false

        while(!isInputOk) {
            val userInput: Int? = scanner.nextLine().toIntOrNull()
            if (userInput != null) {
                if (userInput <= list.size + 1) {
                    if (userInput == 0) {
                        currentArchive.addNote()
                        isInputOk = true
                        PrintNoteListUtils(title, firstItemText, list, currentArchive)
                    } else if (userInput == list.size + 1) {
                        isInputOk = true
                    } else {
                        PrintNoteUtils(list[userInput - 1] as Note)
                        isInputOk = true
                        PrintNoteListUtils(title, firstItemText, list, currentArchive)
                    }
                } else {
                    println("Действия с таким номером не существует, введите число от 0 до ${list.size + 1}")
                }
            } else {
                println("Пожалуйста, введите число от 0 до ${list.size + 1}")
            }
        }
    }
}