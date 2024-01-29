package Data

class Archieve (_name : String) {
    var notes = HashMap<Int, Note>()
    val name: String

    init {
        name = _name
    }

    fun getArchName() : String{
        return name
    }

    fun addNote(note: Note){
        notes[notes.size+1] = note
    }

    fun showAllNotes(){
        for(note in notes){
            println(note.value.name)
        }
    }

    fun chooseNote(noteID: Int){
        println(notes[noteID])
    }

}