import ui.console.exceptions.CommandNotFoundException
import ui.console.nextIntTry
import ui.console.screens.ScreensDriver
import java.util.Scanner

fun main() {
    while(true){
        try{
            val screen = ScreensDriver.currentScreen
            screen!!.show()
            screen.readCommand { Scanner(System.`in`).nextIntTry("Введите целое число") }
        }catch (ex: Exception){
            println("ОШИБКА: ${ex.message}")
        }
    }
}

