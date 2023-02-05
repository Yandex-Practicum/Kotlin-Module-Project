import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle


open class Note : InterfaceNote {

    private val noteList: MutableList<String> = mutableListOf()

    override fun createNote(strNote: String): MutableList<String> {
        val date = LocalDate.now().format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT))
        noteList.add("Note creation date $date: $strNote")
        return noteList
    }

    override fun removeNote(strNote: String): String =
        if (noteList.contains(strNote)) {
            noteList.remove(strNote)
            "Note deleted"
        } else {
            "Note not found"
        }

     override fun replaceNote(newNote: String) {
          noteList.map { it ?: newNote }
     }

     override fun clearNote(): String {
         noteList.clear()
        return "All notes removed"
    }

    override fun printAllNote() {
        println(noteList)
    }


}

