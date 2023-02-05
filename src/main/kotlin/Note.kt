 open class Note : InterfaceNote {


    val noteList: MutableList<String> = mutableListOf()


    override fun createNote(strNote: String): MutableList<String> {
        noteList.add(strNote)
        return noteList
    }

    override fun removeNote(strNote: String): String =
        if (noteList.contains(strNote)) {
            noteList.remove(strNote)
            "Note deleted"
        } else {
            "Note not found"
        }

     override fun replaceNote(newNote: String) {
          noteList.map { it ?: newNote }
     }

     override fun clearNote(): String {
         noteList.clear()
        return "All notes removed"
    }

    override fun printAllNote() {
        println(noteList)
    }


}