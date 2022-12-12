import java.util.*

class Note(
    private val title : String,
    private var text : String?
) {
    private val read: Scanner = Scanner(System.`in`)
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