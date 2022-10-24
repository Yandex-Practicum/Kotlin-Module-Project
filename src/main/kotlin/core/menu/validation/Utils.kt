package core.menu.validation

import core.menu.MenuNode
import core.screens.BaseScreen

fun BaseScreen.strictMenuValidation(input: String) {
    val result = input.toIntOrNull()
    when {
        result == null -> {
            println(ValidationError.NotDigit.message)
            this.start()
        }
        !isMenuInputValid(result) -> {
            println(ValidationError.WrongDigit.message)
            this.start()
        }
        else -> {
            onMenuValidatedEvent(result)
        }
    }
}

fun BaseScreen.softMenuValidation(input: String, onSuccess: (String) -> Unit) {
    val menuIndex = input.toIntOrNull()
    if (menuIndex != null && isMenuInputValid(menuIndex)){
        onMenuValidatedEvent(menuIndex)
    } else {
        onSuccess(input)
    }
}

fun BaseScreen.onMenuValidatedEvent(menuIndex: Int){
    getMenuNode(menuIndex)?.let {
        when(it){
            is MenuNode.Create -> goToScreen(it.destination)
            is MenuNode.Exit -> exitScreen()
            is MenuNode.Pick -> goToScreen(it.destination)
        }
    }
}
