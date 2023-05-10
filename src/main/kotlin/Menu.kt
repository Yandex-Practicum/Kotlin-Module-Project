import java.util.*

abstract class Menu {
    protected val scanner = Scanner(System.`in`)
    private var running: Boolean = true
    open val commands: MutableList<Command> = mutableListOf()

    abstract fun createListCommandAndView()
    fun exit() {
        running = false
    }

    fun view(commands: List<Command>) {
        while (running) {
            commands.forEachIndexed { index, command ->
                println("$index) ${command.name}")
            }

            try {
                val input = scanner.nextInt()
                if (input in commands.indices) {
                    println("Радуемся! =)")
                    commands[input].action.invoke(input)
                } else {
                    println("Такого пункта меню нет. Введите цифру от 0 до ${commands.size - 1} включительно.")
                }
            } catch (e: InputMismatchException) {
                println("Такого пункта меню нет. Введите цифру от 0 до ${commands.size - 1} включительно.")
                scanner.nextLine()
            }
        }
    }
}
