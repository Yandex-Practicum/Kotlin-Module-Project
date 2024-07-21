import dataClass.Archive
import dataClass.Note
import java.util.Scanner

class ScreenCreateArchive {
    fun create(archiveList: MutableList<Any>): Archive{
        var enterStringArchive = ""
        while(enterStringArchive.isEmpty()) {
            println("Введите имя архива")
            enterStringArchive = Scanner(System.`in`).nextLine()
        }
        val noteList = mutableListOf<Any>("0. Создать заметку", "1. Выход к списку архивов")
        val archive = Archive(enterStringArchive, noteList)
        return archive
    }
}