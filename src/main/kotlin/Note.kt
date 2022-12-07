class Note(
    val title : String,
    var text : String?
) {
    fun showNote(){
        println("-- $title --")
        println(text)
    }
    fun addText(newText : String){
        text += newText
    }
    fun removeText(){
        text = ""
    }
}