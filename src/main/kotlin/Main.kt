import AppState.AppState

fun main() {


    do {
        var endedCode: Int = 200
        AppState.showScreen()
        var massage = ""
        do {
            massage = AppState.readText()
            endedCode = AppState.movement(massage)

            if(endedCode ==400) println("Wrong code, pleas try again")
        } while (endedCode==400)


    } while(AppState.locationInApp != "Exit")
    // screenList.onEach { it.showMenu() }

}



