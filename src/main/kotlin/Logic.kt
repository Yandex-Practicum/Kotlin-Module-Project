import java.util.Scanner

class Logic {

    fun askForInput(): String {
        return Scanner(System.`in`).nextLine()
    }

    fun createInput(message: String): String {
        println(message)
        return askForInput()
    }

}