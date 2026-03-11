//fun main(args: Array<String>) {
fun main() {
    val archives = mutableListOf<Archive>()

    ArchiveMenu(archives).start()
    //println("Hello World!")


}

fun readNotEmptyString(errorMessage: String): String {
    val scanner = java.util.Scanner(System.`in`)
    while (true) {
        val input = scanner.nextLine().trim()
        if (input.isNotBlank()) {
            return input
        }
        println()
        println(errorMessage)
        print("Попробуйте снова: ")
    }
}
