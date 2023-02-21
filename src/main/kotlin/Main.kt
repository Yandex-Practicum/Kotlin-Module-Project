import AppState.AppState
import java.util.*

fun main() {


    do {
        var endedCode: Int = 200
        AppState.showScreen()
        var massage = ""
        do {
            massage = readText()
            endedCode = AppState.movement(massage)

            if(endedCode ==400) println("Wrong code, pleas try again")
        } while (endedCode==400)


    } while(AppState.locationInApp != "Exit")
    // screenList.onEach { it.showMenu() }

}

fun readText(): String = Scanner(System.`in`).nextLine()

