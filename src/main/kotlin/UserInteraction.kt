class UserInteraction {
    fun readCommand(): Int {
        return readlnOrNull()?.toIntOrNull() ?: -1
    }

    fun printMenu(menu: List<MenuItem>) {
        menu.forEachIndexed { index, item ->
            println("$index. ${item.title}")
        }
    }

    fun incorrectInput(lastPosition: Int) {
        println("Incorrect input. Please enter a number from 0 to $lastPosition")
    }
}