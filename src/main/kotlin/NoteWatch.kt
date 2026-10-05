class NoteWatch(val note: Note) {
    fun watch() {
        println("\n ------------------------------- \n ${note.text} \n -------------------------------")
    }
}
