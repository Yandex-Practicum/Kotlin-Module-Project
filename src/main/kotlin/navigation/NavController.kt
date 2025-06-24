package navigation

import NoteTakingApp
import utils.Stack
import utils.pop
import utils.push

class NavController(val app: NoteTakingApp) {
    private val navStack: Stack<Screen> = Stack()

    fun isEmpty() = navStack.isEmpty()

    fun navigateBack() = navStack.pop()

    fun navigateTo(screen: Screen) = navStack.push(screen)

    fun currentScreen() = navStack.last()
}