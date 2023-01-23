import java.util.*

class Menu(val nameMenu: String, val firstValue: String = "", val prefix:String,
           listOfSomething:MutableList<String> = mutableListOf("","")) {
    var newMenuArray: MutableList<String> = mutableListOf()

    init {
        newMenuArray.add(firstValue)    //добавление первого пункта "создать"
            for (item in listOfSomething) {
                    newMenuArray.add("$prefix ${item.uppercase()}")
            }
        newMenuArray.add("Выход\n")
    }

    companion object {
        fun printCurrentMenu(currentMenu: Menu){
            println("\nВы находитесь в меню: ${currentMenu.nameMenu}")
            println(" Введите номер пункта меню:")        //печать стартового меню и всех последующих
            for (i in 0 until currentMenu.newMenuArray.size) {
                println(" ${i + 1}. ${currentMenu.newMenuArray[i]}")
            }
        }

        fun openScreen(listOfSomething:MutableList<String>,
                       nameMenu: String, firstValue: String, prefix:String):Menu {
                currentMenu = Menu(nameMenu, firstValue, prefix, listOfSomething)
                return currentMenu
        }

        fun answerConverted():Int {
            return try {
                val answer = Scanner(System.`in`).nextLine()
                val answConv = answer.toInt()
                answConv
            } catch (e: Exception) {
                1000
            }
        }
    }
}


