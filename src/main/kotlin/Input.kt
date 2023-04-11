import java.util.Scanner

object Input {
    private val scanner = Scanner(System.`in`)

    fun readString(prompt: String): String {
        print("$prompt: ")
        return scanner.nextLine()
    }
}