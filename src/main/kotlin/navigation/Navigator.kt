package navigation

import screen.Screen
import java.util.Stack
import kotlin.system.exitProcess

object Navigator {
    private val stack = Stack<Screen>()

    fun pop() {
        stack.pop()
        showScreen()
    }

    private fun showScreen() {
        if (stack.isEmpty()) {
            exitProcess(0)
        }
        stack.last().showMenu()
        stack.last().nextStep()

    }

    fun push(screen: Screen) {
        stack.push(screen)
        showScreen()
    }
}