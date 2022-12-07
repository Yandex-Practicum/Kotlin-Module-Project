import java.util.Scanner
data class NotesList(
    var notes : HashMap<String, Note> = HashMap(),
    var noteNames : HashSet<String> = HashSet()
    ) : Choise(title = "Notes", list = noteNames)
{
    val read: Scanner = Scanner(System.`in`)

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

    fun getTitle(variant : Int) : String{
        var text : String = ""
        when (variant){
            1-> text = "Title is not exist"
            2-> text = "Title is already exist"
        }
        println("Enter the title of note")
        var title : String = read.nextLine()
        when (variant) {
            1 -> {
                while (!noteNames.contains(title)) {
                    println(text)
                    title = read.nextLine()
                }
            }
            2 -> {
                while (noteNames.contains(title)) {
                    println(text)
                    title = read.nextLine()
                }
            }
        }
        return title
    }
}

