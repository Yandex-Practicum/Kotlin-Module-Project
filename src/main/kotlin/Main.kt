import java.util.Scanner

val scanner = Scanner(System.`in`)

val archives = mutableMapOf<String, MutableList<String>>()
var archiveName: String? = null

fun main() {

    println("Добро пожаловать в приложение Заметки!\nВыберите пункт меню:")

    menu("архив",archives.keys,::creationMenu,::menuNotes)

}