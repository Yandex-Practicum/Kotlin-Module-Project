interface InterfaceArchive {

    fun createArchive(titleArchive: String)
    fun removeArchive(titleArchive: String)
    fun addNoteToArchive(titleArchive: String, note:MutableList<String>)
    fun clearArchive()
    fun printAllArchive()
    fun viewNote(titleArchive: String)
    fun createNote(strNote:String):MutableList<String>
    fun removeNote(titleArchive: String)
}
