import java.util.Scanner

object Utils {

    fun commandChecker() : Int? {
        val input = Scanner(System.`in`).nextLine()
        val command = input.toIntOrNull()

        if(command == null){
            println("Ошибка: команда должна быть цифрой")
        }
        return command
    }
}