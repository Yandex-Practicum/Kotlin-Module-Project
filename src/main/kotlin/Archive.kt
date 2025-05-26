
data class Archive (val name:String){

    private val notesList = mutableListOf<Note>()

    fun createNote() {
        println("Укажите название заметки:")
        val nameNote = CheckingDataEntry().inputStringName()
        println("Укажите содержание заметки:")
        val contentNote = CheckingDataEntry().inputStringName()
        notesList.add(Note(nameNote, contentNote))
        println("Заметка '$nameNote' добавлена.")
    }

    fun displayNotes() {
        if (CheckingDataEntry().checkingCollection(notesList)) {
            notesList.forEachIndexed {index, note -> println("${index + 1} - ${note.name}: ${note.content}") }
        }
    }

}

