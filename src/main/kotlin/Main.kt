import java.util.Scanner
val arhive: MutableMap<String,MutableList<String>> = mutableMapOf()
val scanner: Scanner = Scanner(System.`in`)
var archiveName :String? = null
fun main() {
 menu("Архив",arhive.keys,::notes,::create)
}
fun menu(name:String,items:Iterable<String>,openNote:(Int) -> Unit,create:(String)->Unit){
    while (true){
        val scanner: Scanner = Scanner(System.`in`)
        if(name =="Архив") println("Список архивов:") else println("Список заметок:")
        println("0.Создать $name")
        var n = 1
        if(name == "Архив")
        items.forEach{ println("${n++}.Архив-'${it.trim()}'")}
        else items.forEach{ println("${n++}.Заметка-${it.take(5)}...")}
        println("$n.Выход")
        while (scanner.hasNext() and !scanner.hasNextInt()){
            println("Введено неверное значение.Вы ввели ${scanner.next()}.Повторите ввод.")
        }
        var input = scanner.nextInt()
        when(input){
            0 -> create(name)
            in 0 until n -> openNote(input)
            n -> {
                println("Завершение программы заметки.")
                break}
            else -> println("Введено неверное значение.")
        }
    }
}
fun notes(n:Int){
    archiveName = arhive.keys.elementAt(n-1)
    println("Открыт архив : $archiveName")
    menu("Заметку",arhive[archiveName]!!,::showNote,::create)
}
fun editNote(n:Int){
    scanner.nextLine()
    println("Введите новый текст.")
    val text = scanner.nextLine()
    arhive[archiveName]!![n] += text
}


