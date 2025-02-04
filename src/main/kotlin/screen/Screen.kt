package screen

abstract class Screen {

    abstract fun showMenu()

    abstract fun nextStep()

    fun printError(text: String) {
        val red = "\u001b[31m"
        val reset = "\u001b[0m"
        print(red + text + reset)
    }

    fun printInfo(text: String) {
        val red = "\u001b[32m"
        val reset = "\u001b[0m"
        print(red + text + reset)
    }
}

