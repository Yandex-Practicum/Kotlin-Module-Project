import java.util.Scanner

class MenuHandler {
    private val scanner = Scanner(System.`in`)


    fun getUserInput(): String {
        return scanner.nextLine()
    }

    fun isInputWrong(str: String): Boolean {
        return if (str.isNotBlank()) {
            false
        } else {
            println("Содержимое не может быть пустым")
            true
        }
    }


    fun getUserInputInt(): Int? {
        val sc = scanner.nextLine()
        sc.toIntOrNull()?.let {
            return sc.toInt()
        }
        println("! Нужно указать цифру !")
        return null
    }
}
