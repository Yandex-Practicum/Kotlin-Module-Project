import java.util.*
import kotlin.concurrent.schedule

class Note (val header : String, val text: String) {

     companion object {
         fun viewNote(note: Note, indexArchive: Int) {     //Функция вывода списка заметок архива
             println("У Вас открыта заметка '${note.header}'")
             println("-----------------------")
             println(note.text)
             println("-----------------------")
             Thread.sleep(5000L)
             Screen.menuInArchiveScreen(indexArchive)
         }
     }
 }