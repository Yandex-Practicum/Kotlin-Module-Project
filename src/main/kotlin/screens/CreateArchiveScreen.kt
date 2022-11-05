package screens

import data.DataSource
import java.util.*

object CreateArchiveScreen {
    fun start() {
        println("Создание архива\nВведите имя архива:")
        val name = Scanner(System.`in`).nextLine()
        DataSource.addArchive(name)
        println("Архив с именем $name создан")
    }
}