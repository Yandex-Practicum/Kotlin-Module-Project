package screens

import data.DataSource
import java.util.*

object CreateArchiveScreen: CreateScreenAbstract() {
    override val startOfCreationLine = "Создание архива"
    override val endOfCreationLine = "Архив создан!"
    override fun readElement(parentId: Int) {
        println("Введите имя архива:")
        val name = Scanner(System.`in`).nextLine()
        DataSource.addArchive(name)
    }
}