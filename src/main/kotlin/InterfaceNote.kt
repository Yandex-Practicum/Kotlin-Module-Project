interface InterfaceNote {
    fun createNote(strNote:String):List<String>
    fun removeNote(strNote: String):String
    fun replaceNote(newNote:String)
    fun clearNote():String
    fun printAllNote()
}