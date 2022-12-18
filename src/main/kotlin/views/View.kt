package views

import java.util.*
import kotlin.collections.List

abstract class View {
    var isEnd: Boolean = false
    abstract var navigateText: String
    abstract var commandNumbers: Int
    abstract var viewName: String
    private fun showContent(commands: List<Pair<String, () -> Unit>>) {
        println(viewName)
        commands.forEach { println(it.first) }
    }

    abstract fun createCommands(): MutableList<Pair<String, () -> Unit>>
    private fun readCommand(): Int {
        var number: Int?
        while (true) {
            number = Scanner(System.`in`).nextLine().toIntOrNull()
            if (number !in 0 until  createCommands().size) {
                println("Введите команду согласно номеру из списка.")
            } else {
                break
            }
        }
        return number!!
    }

    fun commandReader(): () -> Unit = {
        while (!isEnd) {
            val commands = createCommands()
            showContent(commands)
            val command = readCommand()
            commands[command].second.invoke()
        }
    }

    fun exit(): () -> Unit = {
        println(navigateText)
        isEnd = true
    }
}