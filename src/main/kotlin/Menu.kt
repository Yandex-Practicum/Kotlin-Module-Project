import utils.ErrMessage
import java.util.Scanner
import utils.ErrMessage.*

/**
 * Меню выбора.
 * [menuCommands] хранит в себе список пунктов меню в ввиде [Command]. [Command] содержит
 * текстовое представление пункта меню и соответствующую ему комманду, лямбда-выражение
 * вызывающее одни из экземпляров "Экрана", которые принимаются c аргументами
 * [screenCreator] - "Экран" для создания архива/заметки и [listOfScreens] - список архивов/заметок.
 * [title] - название меню.
 *
 * Навигация осуществляется через [ScreenStack], функциями [ScreenStack.push] для вызова
 * соответсвующего "Экрана" и [ScreenStack.pop] для возврата к предыдущему или завершения
 * программы.
 */
class Menu(
    private val title: String,
    private val screenCreator: Screen,
    private val listOfScreens: MutableList<out Screen>
) {
    private val menuCommands: MutableList<Command> = mutableListOf()

    init {
        menuCommands.add(Command(screenCreator.commandName) { ScreenStack.push(screenCreator) })
    }

    /** Элемент меню(команда).
     * [commandName] - текстовое представление пункта меню,
     * [command] - лямбда-выражение вызывающее соответствущий "Экран"
     */
    private class Command(val commandName: String, val command: () -> Unit)

    /** Запускает меню */
    fun run() {
        commandsUpdate()
        printMenu()
        runCommand(getIntInput())
    }

    /** Обновляет список комманд в меню. */
    private fun commandsUpdate() {
        if (listOfScreens.isEmpty()) return
        if (listOfScreens.size == menuCommands.size - 1) return
        val lastItem = listOfScreens.last()
        menuCommands.add(Command(lastItem.commandName) { ScreenStack.push(lastItem) })
    }

    /** Выводит меню на экран */
    private fun printMenu() {
        var index = 0
        println(title)
        menuCommands.forEach { item -> println("${index++}. ${item.commandName}") }
        println("${menuCommands.size}. Выход")
    }

    /** Проверяет ввод из консоли на корректность и возвращаетцелое целое число
     * используемое для выбора пункта меню и запуска соостветсвующей комманды
     * */
    private fun getIntInput(): Int {
        var input: Int
        val printError: (ErrMessage) -> Unit =
            { message ->
                printMenu()
                println(message)
            }

        do {
            val temp = Scanner(System.`in`).nextLine()
            if (temp.isEmpty()) printError(ERROR_EMPTY)
            else {
                try {
                    input = temp.toInt()
                    if (input in 0..menuCommands.size) break
                    printError(ERROR_OUT_OF_RANGE)
                } catch (e: NumberFormatException) {
                    printError(ERROR_NOT_INT)
                }
            }
        } while (true)
        return input
    }

    /** Вызывает команду меню в соответсвии с [input] */
    private fun runCommand(input: Int) {
        if (input == menuCommands.size) ScreenStack.pop() else menuCommands[input].command()
    }
}