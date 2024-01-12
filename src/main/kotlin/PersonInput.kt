import java.lang.Exception
import java.util.Scanner

class PersonInput {
    companion object {
        // Просто крашу вывод
        val RED = "\u001b[31m"
        val RESET = "\u001b[0m"
    }

    fun inputAnswer(): Int {
        while (true) {
            try {
                print("Введите пожалуйста число: ")
                return Scanner(System.`in`).nextLine().toInt()
            } catch (e: Exception) {
                println(RED + "Введите, пожалуйста цифру" + RESET)
            }
        }
    }

    fun containInput(message: Message): String {
        while (true) {
            print(message.createThing)
            when (val data = Scanner(System.`in`).nextLine().toString()) {
                "" -> {
                    println(RED + message.ERROR_MESSAGE + RESET)
                    continue
                }
                else -> return data
            }
        }
    }
}