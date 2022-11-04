enum class Input(val code: String) {
    EXIT("0"), CREATE("1")
}

fun main() {
    val mainScreen = MainScreen()
    mainScreen.navigate()
}