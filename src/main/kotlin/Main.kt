import Item.Archive
import Item.Note
import Menu.ArchiveMenu
import Menu.BaseMenu

fun main(args: Array<String>) {
    val archives = mutableListOf(
        Archive(
        "Первый Архив",
            mutableListOf(
            Note("Первая заметка","Первая Её содержание"),
            Note("Вторая заметка"," Вторая Её содержание"),
            Note("Третья заметка"," Третья Её содержание")
        )),
        Archive(
            "Второй Архив",
            mutableListOf(
                Note("Первая второго заметка","Первая Её содержание"),
                Note("Вторая второго заметка"," Вторая Её содержание"),
                Note("Третья второго заметка"," Третья Её содержание")
            ))
        )
    //BaseMenu(archives,"Список архивов:", "Создать Архив").start()
    ArchiveMenu(archives, "Список архивов:", "Создать Архив").start()
}