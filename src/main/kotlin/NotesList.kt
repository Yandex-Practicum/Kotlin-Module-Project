import java.util.Scanner
open class NotesList(
    var name : String = "",
    var notes : HashMap<String, Note> = HashMap(),
    var noteNames : HashSet<String> = HashSet()
    ) : Choise(title = name, list = noteNames)
{
    fun createNote(){
        val title = getTitle(2)
        println("Enter the text")
        val text: String = read.nextLine()
        noteNames.add(title)
        notes.set(title, Note(title, text))
        println("The note was created successfully")
    }

    fun showNotes() {
        showElements()
    }

    fun deleteNote(){
        val title = getTitle(1)
        noteNames.remove(title)
        notes.remove(title)
    }

    fun openNote(){
        val title = getTitle(1)
        notes.get(title)?.showNote()
    }
}

