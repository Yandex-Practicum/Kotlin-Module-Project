import java.util.*

class Menu<T>(val title : String, val name : String, val nameForNew : String)  {
    var itemName : String = ""
    private val scanner: Scanner = Scanner(System.`in`)
    private var input : String = ""

    fun select(map : MutableMap<String, T>) : Int {
        val menuList : MutableMap<Int, String> = mutableMapOf()
        var line : Int
        var digitTest : Boolean
        while(true) {
             println()
             println(title)
             println("Введите число от 0 до ${map.size+1} ")
             println("0. Создать $name")
             line = 1
             for (key in map.keys) {
                 println("$line. Выбрать $name $key")
                 menuList.put(line, key)
                 line++
             }
             println("$line. Выход")
             digitTest = scanner.hasNextInt()
             input = scanner.nextLine().trim()

             if (input.isEmpty()) println("Вы ничего не ввели, вводить нужно числа от 0 до $line")
             else {
                if (!digitTest) {
                    println("Вы ввели $input")
                    println("Вы ввели не целое число. Вводить можно только целые числа от 0 до $line")
                }
                else {
                    val menuLine : Int = input.toInt()
                    when (menuLine) {
                        0 -> {
                            println("Вы ввели 0 - Создать $name")
                            itemName = inputName("Введите имя $nameForNew")
                            return 0
                        }
                        in 0..(line - 1) -> {
                            itemName = menuList.get(menuLine)!!
                            println("Вы ввели $menuLine  - Выбрать $name $itemName")
                            return 1
                        }
                        line -> {
                            println("Вы ввели $line - Выход")
                            return 2
                        }
                        else -> {
                            println("На экране нет введенного вами варианта, вводить нужно числа от 0 до $line")
                        }
                    }
                }
            }
        }
    }

    private fun inputName(prompt : String) : String {
        while(true) {
            println(prompt)
            input = scanner.nextLine().trim()
            if (input.isEmpty())
                println("Имя не может быть пустым")
            else
                return input
        }
    }
 }