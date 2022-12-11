import java.util.Scanner

val repo: MutableMap<String, MutableList<String>> = mutableMapOf()
val scanner: Scanner = Scanner(System.`in`)
var archiveName: String? = null

fun main() {
    menu("Архив", repo.keys, ::notes, ::create)
}

fun menu(name: String, items: Iterable<String>, openNote: (Int) -> Unit, create: (String) -> Unit) {
    while (true) {
        if (name == "Архив") println("Список архивов:") else println("Список заметок:")
        println("0.Создать $name")
        var menuCounter = 1
        if (name == "Архив")
            items.forEach { println("${menuCounter++}.Архив- $it") }
        else items.forEach {
            var noteCounter = menuCounter - 1
            println("${menuCounter++}.Заметка ${++noteCounter} - $it")
        }
        println("$menuCounter.Выход")
        while (scanner.hasNext() and !scanner.hasNextInt()) {
            println("Введено неверное значение  ${scanner.next()}.Повторите попытку.")
        }
        when (val input = scanner.nextInt()) {
            0 -> create(name)
            in 0 until menuCounter -> openNote(input)
            menuCounter -> {
                break
            }
            else -> println("Введено неверное значение.")
        }
    }
}



