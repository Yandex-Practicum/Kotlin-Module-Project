import java.util.*

class Note(
    val title : String,
    var text : String?
) {
    val read: Scanner = Scanner(System.`in`)
    fun showNote(){
        println("-- $title --")
        println(text)
    }
    fun addText(){
        println("Enter the text")
        val newText = read.nextLine()
        text += newText
    }
    fun removeText(){
        text = ""
    }
}