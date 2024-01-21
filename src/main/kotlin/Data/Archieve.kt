package Data

class Archieve (_name : String) {
    var notes: MutableList<Note> = mutableListOf()
    val name: String

    init {
        name = _name
    }

    fun getArchName() : String{
        return name
    }

    fun addNote(note: Note){
        notes.add(note)
    }

    fun showAllNotes(){
        for(note in notes){
            println(note.name)
        }
    }

    fun chooseNote(noteID: Int){
        println(notes[noteID])
    }

}