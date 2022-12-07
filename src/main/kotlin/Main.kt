import java.util.Scanner
fun main() {
    val read = Scanner(System.`in`)
    var list: NotesList = NotesList()
    list.createNote()
    println("-----------------------------------------")
    list.showNotes()
    println("-----------------------------------------")
    list.showNotes()
    list.openNote()
    list.deleteNote()
}
