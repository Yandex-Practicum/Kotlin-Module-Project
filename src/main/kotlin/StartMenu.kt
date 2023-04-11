import java.util.*

    abstract class StartMenu {

        private val scanner = Scanner(System.`in`)
        protected var isRunning = true
        protected val menuStack = Stack<StartMenu>()

        abstract fun displayOptions()

        open fun run() {
            while (isRunning) {
                displayOptions()
                handleInput()
            }
        }

        abstract fun handleInput()

        protected fun goBack() {
            if (menuStack.isNotEmpty()) {
                isRunning = false
                menuStack.pop().run()
            } else {
                isRunning = false
            }
        }
    }