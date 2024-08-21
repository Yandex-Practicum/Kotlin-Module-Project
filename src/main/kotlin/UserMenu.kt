import java.util.Scanner

class UserMenu {
    fun showMenu(header: String, menu: List<Pair<String,(Int)->Unit>>){
        var i = 0
        println(header)
        for (item in menu) println("${i++} - ${item.first}")
    }

    fun start(header: String, menu: MutableList<Pair<String,(Int)->Unit>>){
        while (true) {
            showMenu(header, menu)
            val input = Scanner(System.`in`).nextLine()
            if (!inputCorrect(input)) continue
            val indexMenu = input.toInt()
            if (indexMenu >= 0 && indexMenu < menu.size) menu[indexMenu].second(indexMenu - 1)
            else println("Вы ввели неверный номер. Введите номер пункта меню.")
            if (indexMenu == 0) break //пункт меню "Создать ..."
            if (indexMenu == menu.size-1) break //пункт меню "Выход"
        }
    }

    private fun inputCorrect(input: String):Boolean{
        if (input.isBlank()) {
            println("Вы ввели пустую строку. Введите номер пункта меню.")
            return false
        }
        if (input.all { it.isDigit() } == false) {
            println("Вы ввели не число. Введите номер пункта меню.")
            return false
        }
        return true
    }
}