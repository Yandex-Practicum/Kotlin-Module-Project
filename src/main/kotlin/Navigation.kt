import java.util.*

class Navigation() {

    fun checkInput(): Int {
        var output: Int? = null
        while (output == null) {
            println("Введите число, соответствующее выбранному пункту меню")
            val input = Scanner(System.`in`).nextLine().trim()
            output = try {
                input.toInt()
            } catch (e: java.lang.NumberFormatException) {
                null
            }
        }
        return output
    }

    fun showMenu(menu: MutableList<String>) {
        println("Выберите пункт меню:")
        for (i in menu) {
            println("${menu.indexOf(i)}: $i")
        }
    }

   /* fun makeChoice(, input: Int) {
        when(input) {
            0 -> makeArchive()
            1 -> return
            in 2..menu.size - 1 -> {
                contain.elementAt(input - 2).showMenu()
            }
            else -> {
                println("Введите число, соответствующее пункту меню")
            }
        }
    }*/
}
