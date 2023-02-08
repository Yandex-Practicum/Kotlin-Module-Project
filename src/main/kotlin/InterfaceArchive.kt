interface InterfaceArchive {

    fun createArchive(titleArchive: String)
    fun removeArchive(titleArchive: String)
    fun addNoteToArchive(titleArchive: String)
    fun clearArchive()
    fun printAllArchive()
    fun printAllNote()
    fun createNote(strNote:String)
    fun removeNote(titleArchive: String)

}
