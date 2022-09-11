import java.util.*

class UserDialogue() {
    fun chooseCommand(currentCommands: List<Pair<String, () -> Unit>>) {
        while (true) {
            currentCommands.forEach { element -> println(element.first) }
            val action = Scanner(System.`in`).nextLine().toIntOrNull()
            if (action == null) {
                println("Необходимо ввести цифру")
                continue
            }

            if (action !in 0 until currentCommands.size) {
                println("Необходимо ввести цифру от 0 до ${currentCommands.size - 1}")
                continue
            }

            currentCommands[action].second()
            break
        }
    }

    fun getAnswer(question: String): String {
        println(question)
        return Scanner(System.`in`).nextLine()
    }
}