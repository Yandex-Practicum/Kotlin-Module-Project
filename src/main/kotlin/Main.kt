import java.util.Scanner

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val menu = MainMenu(scanner)
    val archives =
        HashMap<String, HashMap<String, String>>() // Коллекция для хранения архивов и заметок
    menu.show(archives)
}

