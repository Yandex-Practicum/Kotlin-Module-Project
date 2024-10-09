package menu
import modules.Archive
import utils.readNonBlankString

fun createArchive(archives: MutableList<Archive>) {
    val name = readNonBlankString("Введите название архива:")
    archives.add(Archive(name))
    println("Архив \"$name\" был создан")
}