import java.util.Scanner

fun inputString(inputMessage: String): String {
    while (true) {
        println("${inputMessage}:")

        val inputString = Scanner(System.`in`).nextLine()
        if (inputString.isEmpty())
            println("Необходимо ввести данные для продолжения.")
        else
            return inputString
    }
}