import archives.ChooseArchiveScreen
import archives.CreateArchiveScreen
import base.*
import java.util.*


val listOfArchives: MutableList<Archive> = mutableListOf<Archive>()

fun main() {
    while (true) {
        showOptions()
        when (Scanner(System.`in`).nextLine().toString()) {
            "1" -> ChooseArchiveScreen.showText(listOfArchives, BaseOpener.ARCHIVE_TEXT)
            "2" -> ChooseArchiveScreen.openText(listOfArchives)
            "3" -> CreateArchiveScreen.createText(null)
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
