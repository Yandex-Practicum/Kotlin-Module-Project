interface InterfaceArchive {

    fun createArchive(titleArchive: String)
    fun removeArchive(titleArchive: String)
    fun addNoteToArchive(titleArchive: String, note:String)
    fun clearArchive()
    fun printAllArchive()
    fun printAllNote()
    fun viewNote(titleArchive: String)
    fun createNote(strNote:String):String
    fun removeNote(titleArchive: String)
}
