package ui.console.screens

import ui.IScreen
import ui.console.move
import java.util.Stack
import java.util.LinkedList
import java.util.Queue
import kotlin.system.exitProcess

object ScreensDriver {
    private val FORWARD_QUEUE: Queue<IScreen> = LinkedList()
    private val BACKWARD_STACK: Stack<IScreen> = Stack<IScreen>()

    var currentScreen: IScreen? = null
    init{
        FORWARD_QUEUE.add(Screens.Archives(::goForward, ::goBack))
        FORWARD_QUEUE.add(Screens.Archive(::goForward, ::goBack))
        FORWARD_QUEUE.add(Screens.OpenNote(::goForward, ::goBack))

        currentScreen = FORWARD_QUEUE.peek()
    }
    private fun exit() { exitProcess(-1) }
    private fun goForward() {
        val screen = FORWARD_QUEUE move BACKWARD_STACK
        currentScreen = screen
    }
    private fun goBack() {
        try{
            val screen = BACKWARD_STACK move FORWARD_QUEUE
            currentScreen = screen
        } catch(ex: Exception){
            exit()
        }
    }
}