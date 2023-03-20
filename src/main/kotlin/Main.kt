import java.util.*

val scanner = Scanner(System.`in`)
val archives = mutableMapOf<String, MutableMap<String, String>>()
var currentArchive: String? = null

fun main() {
    println("=====================================")
    val mainMenu = MainMenu()
    mainMenu.show()
}

abstract class Screen<T> {
    abstract fun show()
}