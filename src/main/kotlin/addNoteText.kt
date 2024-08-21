import java.util.Scanner

fun addNoteText(note:Note){
    var noteText = ""
    while(true){
        println("Введите текст заметки:")
        val input = Scanner(System.`in`).nextLine()
        if (input.isBlank()) println("Пустой текст заметки недопустим.")
        else {
            noteText = input
            break
        }
    }
    note.text += "\n" + noteText
}