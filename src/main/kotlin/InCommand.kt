import java.lang.Exception
import java.util.*

class InCommand {

    fun executeCommand(instance:Screen, listObjects: MutableList<out Screen>): String {
        try {
            val command = Scanner(System.`in`).nextLine()
            when (command) {
                "0" -> instance.addObject()
                "${listObjects.size + 1}" -> return instance.overModule
                else -> listObjects[command.toInt() - 1].showObjects()
            }
        } catch (e: Exception) {
            println("Некорректно введенные данные. \nПопробуйте снова.")
        }
        return ""
    }
}