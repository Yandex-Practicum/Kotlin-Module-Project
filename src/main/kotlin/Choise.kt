import java.util.*
import kotlin.collections.HashSet

open class Choise(
    val title : String,
    var list : HashSet<String>
) {
    val read: Scanner = Scanner(System.`in`)
    open fun showElements(){
        println("$title:")
        var position = 1
        for (element in list)
            println("${position++}. $element" )
        if(list.size == 0)
            println("now is empty")
    }
    fun getTitle(variant : Int) : String{
        val text : String
        println("Enter the title")
        var title : String = read.nextLine()
        when (variant) {
            1 -> {
                text = "Title is not exist"
                while (!list.contains(title)) {
                    println(text)
                    title = read.nextLine()
                }
            }
            2 -> {
                text = "Title is already exist"
                while (list.contains(title)) {
                    println(text)
                    title = read.nextLine()
                }
            }
        }
        return title
    }
}