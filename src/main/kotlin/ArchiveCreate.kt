import java.util.Scanner

open class ArchiveCreate {
    fun createArchive(list: MutableList<DataArchive>) {
    println("Введите имя архива:")
    val name = Scanner(System.`in`).nextLine()
    if (name.isBlank()) {
        println("Имя не может быть пустым")
        return
    }
    list.add(DataArchive(name))}
}