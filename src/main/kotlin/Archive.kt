class Archive(archiveName: String) {
    var archiveName: String = ""
    var noteList = mutableMapOf<String, Note?>()


    fun showNotes(): Array<Note?> {
        if(noteList.isNotEmpty()) {
            return noteList.map { it.value }.toTypedArray()
        } else {
            return (arrayOfNulls<Note?>(1))
        }
    }

    fun addNote(noteName: String, noteContent: String){
        val note = Note(noteName, noteContent)
        noteList.put(noteName, note)
    }


    var listOfOptions: MutableList<String?> = mutableListOf("Создать заметку", "Показать заметки")

}