import java.util.*

open class Page<T>(
    var command: String,
    private val pageDescription: String,
    var mutableList: MutableList<T>,
    private var currentElementIndex: Int = -1
) {
    fun action() {
        run()
    }

    open fun execCreateCommand(input: String) {
    }

    open fun execElementCommand(commandNumber: Int) {
    }

    private fun run() {
        while(true) {
            when (val commandNumber: Int = chooseCommand(mutableList)) {
                0 -> {
                    return
                }
                1 -> {
                    when(command) {
                        "Создать" -> {
                            command = "Введите содержимое"
                            run()
                            command = "Создать"
                        }
                        "Показать" -> {
                            println(mutableList.elementAt(currentElementIndex).toString())
                        }
                        "Введите содержимое" -> {
                            var input: String
                            do {
                                println("Введите корректное содержимое из консоли:")
                                input = Scanner(System.`in`).nextLine()
                            } while (input.isEmpty())
                            execCreateCommand(input)
                        }
                    }
                }
                in 2..mutableList.size + 1 -> {
                    currentElementIndex = commandNumber - 2
                    execElementCommand(currentElementIndex)
                    currentElementIndex = -1
                }
            }
        }
    }

    private fun menu(mutableList: MutableList<T>) {
        println(pageDescription)
        println("0: Выход")
        println("1: $command")

        if (command == "Создать") {
            for (index in 0 until mutableList.size) {
                println("${index + 2}: ${mutableList.elementAt(index).toString()}")
            }
        }
    }

    private fun chooseCommand(mutableList: MutableList<T>): Int {
        menu(mutableList)
        var input: String
        do {
            if (command == "Создать") {
                println("Введите номер команды от 0 до ${mutableList.size + 1}:")
            } else {
                println("Введите номер команды от 0 до 1")
            }
            input = Scanner(System.`in`).nextLine()
        } while (!validate(input, mutableList.size + 1))

        return input.toInt(10)
    }

    private fun validate(input: String, rightRange: Int): Boolean {
        val number: Int
        try {
            number = input.toInt(10)
        } catch (e: NumberFormatException) {
            println("Некорректный ввод")
            return false
        } catch (e: IllegalArgumentException) {
            println("Некорректный ввод")
            return false
        }

        if (number !in 0..rightRange) {
            println("Некорректный ввод")
            return false
        }

        return true
    }
}
