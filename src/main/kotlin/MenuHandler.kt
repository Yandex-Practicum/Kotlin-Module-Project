
import TypeMenu.*
import java.util.Scanner
class MenuHandler {
    val scanner = Scanner(System.`in`)


    fun getUserInput(): String {
        val sca = scanner.nextLine()
        return sca
    }

    fun isImputWrong(str: String): Boolean {
        if (!str.isBlank()) {
            return false
        } else {
            println("Содержимое не может быть пустым")
            return true
        }
    }


    fun getUserInputInt(): Int? {
        val sc = scanner.nextLine()
        if (isInt(sc)){
            val inter = sc.toInt()
            return inter
        } else {
            println("! Нужно указать цифру !")
        return null}

    }

    fun isInt(s: String): Boolean {
        try {
            s.toInt()
            return true
        } catch (e: NumberFormatException) {
            return false
        }

    }
}