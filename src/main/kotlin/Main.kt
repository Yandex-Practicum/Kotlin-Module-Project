import java.util.Scanner

fun main() {
    val archiveList = mutableListOf<Archive>(Archive("test"))
    PrintListUtils("Список архивов", "архив", archiveList)
}
