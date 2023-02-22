import java.util.*

//пункт меню - имя и действие при выборе
class NavItem (val name: String, val onSelect: () -> Unit)

object Navigator {

    val scanner = Scanner(System.`in`)

    //текущий список пунктов меню
    var menu: MutableMap<Int, NavItem> = mutableMapOf()

    //работа навигатора
    fun run() {

        while (menu.size > 0) {
            for (key in menu.keys.sorted()) {
                println("$key. ${menu[key]!!.name}")
            }
            if (scanner.hasNextInt()) {
                val i: Int = scanner.nextInt();
                if (menu.get(i) == null) {
                    println("Необходимо ввести число - номер пункта меню")
                } else {
                    menu.get(i)!!.onSelect();
                }
            } else {
                println("Необходимо ввести число - номер пункта меню")
                scanner.next()
            }
        }
    }
}