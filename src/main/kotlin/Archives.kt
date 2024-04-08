class Archive(val titel: String) {

    val noteList = mutableListOf<Notes>()
    fun addMoreNote(titel: String, text: String) {
        val note = Notes(titel, text)
        noteList.add(note)
    }

    fun readNoteList() {
        if (noteList.isNotEmpty()) {
            for ((index, note) in noteList.withIndex()) {
                println("${index + 1} ${note.titel} ${note.text}")
            }
        } else {
            println("заметок не найдено")
        }
    }
}