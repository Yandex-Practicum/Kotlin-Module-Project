import java.util.Scanner

class Logic {
    fun askForInput(): String {
        println("Please choose an option or enter \"back\" to return to the previous menu")
        return Scanner(System.`in`).nextLine()
    }

}