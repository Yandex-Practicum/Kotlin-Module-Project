import java.util.Scanner
val archives: MutableMap<String, MutableMap<String, String>> = mutableMapOf()
val scanner: Scanner = Scanner(System.`in`)
var archiveName: String? = null
fun main() {
    println("Добро пожаловать в приложение 'Заметки'")
    menu("архивов","Выход",archives.keys,::createArchive,::openArchive)
    println("Выхожу из программы")

}
fun menu(name: String, exit: String, menuList: Iterable<String>,toCreationMenu: () -> Unit,
         toNextMenu: (input: Int) -> Unit){
    while(true){
        println("Список $name: \n0. Создать")
        var counter = 1
        menuList.forEach { println("${counter++}. $it") }
        println("$counter. $exit")
        while (scanner.hasNext() and !scanner.hasNextInt()) {
            println("Введено неверное значение  ${scanner.next()}.Повторите попытку.")
        }
        val input = scanner.nextInt()
        when (input) {
            0 -> toCreationMenu()
            in 0 until counter -> toNextMenu(input)
            counter ->{break}
            else -> println("Такого числа нет в списке, повторите попытку.")
        }
    }
}

fun createArchive() {
    println("Введите название нового архива:")
    scanner.nextLine()
    val archiveName = scanner.nextLine()
    archives[archiveName] = mutableMapOf()
    println("Создан архив: '$archiveName'")
}

fun openArchive(input: Int) {
    archiveName = archives.keys.elementAt(input - 1)
    println("Открыт архив: $archiveName\n")
    menu("заметок", "Назад", archives[archiveName]!!.keys, ::createNote, ::showNote)
}