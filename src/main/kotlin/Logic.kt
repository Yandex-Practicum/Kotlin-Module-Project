import java.util.Scanner

class Logic {

    fun askForInput(message: String): String {
        println(message)
        return Scanner(System.`in`).nextLine()
    }

}