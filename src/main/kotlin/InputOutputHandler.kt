import java.util.Scanner

class InputOutputHandler(
    private val listOfMenuCommands: Map<String, (() -> Unit)?>
) {
    private val tmpListOfCommand = mutableListOf<(() -> Unit)>()
    fun inputOutputOperations(select: Selectable) {
        listOfMenuCommands.forEach { (s, f) ->
            println(s)
            if (f != null) tmpListOfCommand.add(f)
        }

        tmpListOfCommand[userInputForMenu(select)].invoke()
    }

    fun inputOutputOperations(create: Creatable) {
        listOfMenuCommands.forEach { (s, f) ->
            println(s)
            f?.invoke()
        }
    }

    private fun userInputForMenu(s: Selectable): Int {
        var inputInt: Int
        do {
            try {
                inputInt = Scanner(System.`in`).nextInt()
            } catch (e: Exception) {
                println("Необходимо вводить числа!")
                continue
            }

            if (inputInt !in 0 until tmpListOfCommand.size) {
                println("Такого пункта нет!")
                continue
            }

            return inputInt
        } while (true)
    }
}