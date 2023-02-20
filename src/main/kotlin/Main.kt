
import AppState.AppState
import java.util.*
fun main() {


    while (true) {

        AppState.showScreen()

        AppState.nextScreen(enteredCode = 0)
        AppState.showScreen()?.showMenu()

        var scanner = Scanner(System.`in`).nextLine()

        if (scanner == "0") {break}

    }
   // screenList.onEach { it.showMenu() }

}


