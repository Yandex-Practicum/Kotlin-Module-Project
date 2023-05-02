import java.util.*

abstract class Menu {
    protected val scanner = Scanner(System.`in`)
    private var running : Boolean = true
    open val commands: MutableList<Command> = mutableListOf()

//    fun testCommand(value: Int, maxNumberCommand: Int): Boolean {
//        return value.toIntOrNull()?.let {
//            it in 0..maxNumberCommand
//        } ?: false
//    }

    abstract fun createListCommandAndView()
    fun exit() {
        running = false
    }

    fun view(commands : List<Command>) {
        while (running) {
            commands.forEachIndexed { index, command ->
                println("$index) ${command.name}")
            }
            val input = scanner.nextInt()
            if (input in 0..commands.size) {
                println("Радуемся! =)")
                commands[input].action.invoke(input)
            }
        }
    }
}