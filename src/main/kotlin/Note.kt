import java.util.*

class Note(val title : String) {
    val text : MutableList<String> = mutableListOf()
    private val scanner: Scanner = Scanner(System.`in`)
    private var input : String = ""
    var lineNumber : Int = 1
    fun inputText() {
        while(true) {
            println("Введите $lineNumber строку заметки. Для завершения ввода заметки введите строку \$quit ")
            input = scanner.nextLine().trimEnd()
            if (input == "\$quit") break
            text.add(input)
            lineNumber++
        }
    }
}
