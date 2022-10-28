import archives.ChooseArchiveScreen
import archives.CreateArchiveScreen
import base.*
import java.util.*


val listOfArchives: MutableList<Archive> = mutableListOf()


fun main() {
    while (true) {
        showOptions()
        when (Scanner(System.`in`).nextLine().toString()) {
            "1" -> ChooseArchiveScreen.showArchives()
            "2" -> ChooseArchiveScreen.openArchive()
            "3" -> CreateArchiveScreen.createArchive()
            "0" -> {
                println("бб"); break;
            }

            else -> println("Неправильная команда")
        }
    }
}

private fun showOptions() {
    println()
    println("------------------------------------------------")
    println("Чтобы посмотреть список архивов нажмите - 1")
    println("Чтобы открыть архив нажмите - 2")
    println("Чтобы создать архив нажмите - 3")
    println("Для выхода из программы нажмите - 0")
    println("------------------------------------------------")
    println()
}
