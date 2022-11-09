import entities.MenuItem
import java.util.*

class MenuLogic(private val menu: MutableList<MenuItem>) {

    fun showMenu() {
        println()
        for ((index, value) in menu.withIndex()) {
            println("$index) ${value.name}")
        }
        println()

        selectMenuOption()
    }

    private fun selectMenuOption() {
        while (true) {
            print("Выберете нужный пункт меню: ")
            val answer = Scanner(System.`in`).nextLine().toString()
            println()
            if (answer.toIntOrNull() != null) {
                val menuIndex = answer.toInt()
                if ((menuIndex >= menu.size) or (menuIndex < 0)) {
                    println("Данный пункт меню недоступен")
                } else {
                    menu[answer.toInt()].action()
                }
            } else {
                println("Была введене не цифра. Попробуйте ещё раз.")
            }
        }
    }
}