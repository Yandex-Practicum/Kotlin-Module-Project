open class NotesList(
    name : String = "",
    private var notes : HashMap<String, Note> = HashMap(),
    private var noteNames : HashSet<String> = HashSet()
    ) : Choise(title = name, list = noteNames)
{
    fun createNote(){
        val title = getTitle(2)
        println("Enter the text")
        val text: String = read.nextLine()
        noteNames.add(title)
        notes[title] = Note(title, text)
        println("The note was created successfully")
        showNotes()
    }

    fun showNotes() {
        showElements()
    }

    fun deleteNote(){
        val title = getTitle(1)
        noteNames.remove(title)
        notes.remove(title)
        showNotes()
    }

    fun openNote(){
        val title = getTitle(1)
        notes[title]?.showNote()
    }
    fun redactNote(){
        val title = getTitle(1)
        notes[title]?.addText()
    }
    fun cleanNote(){
        val title = getTitle(1)
        notes[title]?.removeText()
    }
}

