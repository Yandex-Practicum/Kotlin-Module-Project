/*класс Меню Архивов содержит в себе меню - список строк, которые показывают некоторые опции
* и контент - список для хранения архивов
* при создании нового архива он отправляется в контент, а запись о нем - в меню*/

import java.util.*

class ArchiveMenu() {
    val contain: MutableSet<Archive> = mutableSetOf()
    val menu: MutableList<String> = mutableListOf("Создать архив", "Выйти из программы")

    fun showArchiveMenu() {

        while(true) {
            println("Выберите пункт меню:")
            for(i in menu) {
                println("${menu.indexOf(i)}: $i")
            }
            var input: Int = 42
            try {
                input = Scanner(System.`in`).nextLine().toInt()
            } catch(e: NumberFormatException) {
                println("Вы попытались ввести строку")
            }

            when(input) {
                0 -> {
                    println("Введите имя архива:")
                    val newArchive: Archive = Archive(Scanner(System.`in`).nextLine())
                    contain.add(newArchive)
                    menu.add(newArchive.name)
                    println("${newArchive.name} добавлен к списку архивов")
                }
                1 -> break
                in 2..menu.size - 1 -> {
                    contain.elementAt(input-2).showContent()
                }
                else -> {
                   // println("${menu[input.toInt()]}")
                    println("Введите число, соответствующее пункту меню")
                }
            }
        }

    }
}