import java.util.*
import kotlin.collections.ArrayList

class PrintListUtils
    <T>(
    private val title: String,
    private val firstItemText: String,
    private val list: MutableList<T>
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
                        createNewArchive()
                        isInputOk = true
                        PrintListUtils(title, firstItemText, list)
                    } else if (userInput == list.size + 1) {
                        isInputOk = true
                    } else {
                        val currentArchive: Archive = list[userInput - 1] as Archive
                        PrintNoteListUtils(
                            "Список заметок:",
                            "заметку",
                            currentArchive.returnNoteList(),
                            currentArchive
                        )
                        isInputOk = true
                        PrintListUtils(title, firstItemText, list)
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