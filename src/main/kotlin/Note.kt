import java.util.Scanner

class Note(val name: String, var text: String) {
    fun addText(note: Note){
        println("Введите текст")
        val scanner = Scanner(System.`in`)
        while (true) {
            val newText = scanner.nextLine()
            if (newText.isNullOrEmpty()) {
                println("Необходимо ввести текст")
            } else {
                note.text = note.text + "\n$newText"
                return
            }
        }
    }
}