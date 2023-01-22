/*класс Меню Архивов содержит в себе меню - список строк, которые показывают некоторые опции
* и контент - список для хранения архивов
* при создании нового архива он отправляется в контент, а запись о нем - в меню*/

import java.util.*

class ArchiveMenu() {
    val contain: MutableSet<Archive> = mutableSetOf()
    val menu: MutableList<String> = mutableListOf("Создать архив", "Выйти из программы")
    val navigator = Navigation()

    fun makeArchive() {
        println("Введите имя архива:")
        val newArchive = Archive(Scanner(System.`in`).nextLine())
        contain.add(newArchive)
        menu.add("Открыть архив ${newArchive.name}")
        println("${newArchive.name} добавлен к списку архивов")
    }
    fun showArchiveMenu() {

        while(true) {
            navigator.showMenu(menu)
            val input = navigator.checkInput()
            when(input) {
                0 -> makeArchive()
                1 -> return
                in 2..menu.size - 1 -> {
                    contain.elementAt(input-2).showMenu()
                }
                else -> {
                   println("Введите число, соответствующее пункту меню")
                }
            }
        }

    }
}