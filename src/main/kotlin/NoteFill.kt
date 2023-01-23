import java.util.Scanner

val notesText: MutableMap<String, String> = mutableMapOf()//массив для хранения текстов заметок Note
//notesText.key( имя архива)+ notesText.value (текст заметки)

class NoteFill {

    fun noteFill(text: String) {
        println("Enter the text in the line below: ")
        var newNoteText: String? = Scanner(System.`in`).nextLine()
        if (newNoteText.isNullOrEmpty()) {
            newNoteText = ""
        }
        val savedNoteText: String? = notesText[text]
        notesText[text] = "${savedNoteText}\n${newNoteText}"
    }
}