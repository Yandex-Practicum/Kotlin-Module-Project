import java.util.Scanner

fun <T:Lst>putList(archives: MutableList<T>){
    val size = archives.size
    for (i in 2 until size+2){
        println("$i. ${archives[i-2].title}")
    }
}
fun getText(): String{
    var title = Scanner(System.`in`).nextLine()
    while (title.isBlank()) {
        println("Данное поле не может быть пустым")
        title = Scanner(System.`in`).nextLine()
    }
    return title
}

fun <T:Lst>putMenu(list: MutableList<T>){
    println("1. Создать")
    putList<T>(list)
    println("${list.size+2}. Выход")
}
fun putExit(){
    println("Выход")
}