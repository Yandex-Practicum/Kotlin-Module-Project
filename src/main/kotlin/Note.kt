data class Note(val noteName:String, val noteContent:String) {

    fun getName(): String{
        return noteName
    }

    fun getContent(): String{
        return noteContent
    }
}