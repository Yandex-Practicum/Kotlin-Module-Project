/*класс Меню Архивов содержит в себе меню - список строк, которые показывают некоторые опции
* и контент - список для хранения архивов
* при создании нового архива он отправляется в контент, а запись о нем - в меню*/

import java.util.*
import kotlin.system.exitProcess

class StartMenu() : Menu<Archive>(mutableMapOf(), mutableMapOf()) {
  //  val contain: MutableMap<String, Archive> = mutableMapOf()
  //  val menu: MutableMap<String, () -> Unit> = mutableMapOf()
         val navigator = Navigation<Archive?>()

    fun makeArchive() {
        println("Введите имя архива:")
        val newArchive = Archive(Scanner(System.`in`).nextLine())
        content.put(newArchive.name, newArchive)
        menu["Открыть ${newArchive.name}"] = {navigator.show(content[newArchive.name])}
        println("${newArchive.name} добавлен к списку архивов")
    }
     // вывести

}