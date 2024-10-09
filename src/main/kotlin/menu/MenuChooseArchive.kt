import modules.Archive
import utils.readIntInput

fun chooseArchive(archives: List<Archive>) : Archive? {
    if (archives.isEmpty()) {
        println("Архивов нет")
        return null
    }

    println("Список архивов")
    archives.forEachIndexed { index, archive -> println("${index + 1}. ${archive.nameArchive}") }
    println("0. Назад")

    val action = readIntInput("Введите номер архива", 0, archives.size)
    return if (action == 0) return null else archives[action - 1]
}