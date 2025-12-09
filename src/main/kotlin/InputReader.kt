import java.util.Scanner

class InputReader {
    private val scanner = Scanner(System.`in`)
;
    fun readLine(prompt: String? = null): String {
        if (prompt != null) print(prompt)
        return scanner.nextLine()
    }
}
