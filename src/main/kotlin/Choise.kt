open class Choise(
    val title : String,
    var list : HashSet<String>
) {
    open fun showElements(){
        println("$title :")
        var position = 0
        for (element in list)
            println("${position}. $element" )
    }
}