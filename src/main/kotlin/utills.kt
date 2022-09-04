import java.util.Scanner

fun createNewArchive(): String {
    val scanner = Scanner(System.`in`)
    println("Введите название архива")
    return scanner.nextLine()
}