/*класс Меню Архивов содержит в себе меню - список строк, которые показывают некоторые опции
* и контент - список для хранения архивов
* при создании нового архива он отправляется в контент, а запись о нем - в меню*/

import java.util.*

class ArchiveMenu() {
    val contain: MutableMap<String, Archive> = mutableMapOf()
    val menu: MutableMap<String, () -> Unit> = mutableMapOf()
    val navigator = Navigation()

    fun makeArchive() {
        println("Введите имя архива:")
        val newArchive = Archive(Scanner(System.`in`).nextLine())
        contain.put(newArchive.name, newArchive)
        menu["Открыть ${newArchive.name}"] = { contain[newArchive.name]?.showMenu()}
        println("${newArchive.name} добавлен к списку архивов")
    }
     // вывести
    fun showArchiveMenu() {
         while(true) {
             menu["0: Создать архив"] = {makeArchive()}
             menu["1: Выйти"] = {println("Функция выхода из программы")}
             menu.keys.forEach { println("$it") }
             val input = navigator.checkInput()
             menu.values.toList()[input].invoke()
        }

    }
}