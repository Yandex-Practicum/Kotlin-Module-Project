import java.util.Scanner

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val navigator = MenuNavigator(scanner)
    val archives = mutableListOf<Archive>()
    ArchiveMenu(archives, navigator).show()

}