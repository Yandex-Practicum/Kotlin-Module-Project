import java.util.Scanner

abstract class Commander {
    var menu: MutableMap<Int, String> = HashMap()
    var menuNumb: Int = 0
    var choice: Int = 0
    var noteText: MutableMap<Int, String> = HashMap()

    fun command(): Int {
        for (j in 1..menu.size) {
            val str = menu[j]
            println("$j. $str")
        }
        return menu.size
    }

    fun commandReader(): Int {
        var comChoice = 0
        while (true) {
            val reader = readLine()
            if (reader != null) {
                if (reader.toIntOrNull() != null) {
                    comChoice = reader.toInt()
                    return comChoice
                } else println("Введите один из пунктов меню в виде числа")
            }
        }
    }

    abstract fun printing()
}