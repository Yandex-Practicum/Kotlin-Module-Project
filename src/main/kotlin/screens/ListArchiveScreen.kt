package screens

import data.Archive
import java.util.*
import kotlin.system.exitProcess

class ListArchiveScreen(private val list: MutableList<Archive>) : Screen<Archive>("архив", list) {

    override fun add() {
        println("Создание нового архива.\nВведите имя нового архива:")

        val name = Scanner(System.`in`).nextLine()
        list.add(Archive(name, mutableListOf()))

        println("Архив заметок успешно создан!\n")
        show()
    }

    override fun select(i: Int) {
        ListNotesScreen(list[i].notes, this).show()
    }

    override fun exit() {
        exitProcess(1)
    }

}