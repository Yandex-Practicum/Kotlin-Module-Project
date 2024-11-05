class Archive(
    private val name: String
) {
    private val listNotes = mutableListOf<Note>()   // список заметок


    public fun createNewNote(name: String, text: String): Boolean{
        val newNote = Note(name, text)
        if (listNotes.none {it.getName() == name})
        {
            listNotes.add(newNote)
            return true
        }
        return false
    }

    public fun addNote(note: Note){
        listNotes.add(note)
    }

    public fun getName(): String{
        return this.name
    }

    public fun getListOfNotes(): Array<String>{
        return listNotes.map {it.getName()}.toTypedArray()
    }

    public fun getNote(name: String): Note?{
        return listNotes.find { it.getName() == name }
    }

}