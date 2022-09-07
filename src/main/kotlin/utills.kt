import java.util.Scanner

val archiveList = mutableListOf<Archive>()

fun createNewArchive(): Unit {
    val scanner = Scanner(System.`in`)
    println("Введите название архива")
    val newArchiveName = scanner.nextLine()
    archiveList.add(Archive(newArchiveName))
}