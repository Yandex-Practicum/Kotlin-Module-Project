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

    fun showAllNotes() : String{
        for(note in notes){
            println(note.key.toString() + ". " + note.value.name)
        }
        return "Заметок нет"
    }

    fun chooseNote(noteID: Int){
        println("Описание: " + notes[noteID]?.description)
    }

}