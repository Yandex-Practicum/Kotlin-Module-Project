import java.util.Scanner

open class Page {
    fun navigate(
        onCreate: () -> Unit,
        onClick: (value: Int) -> Unit,
        onExit: () -> Unit
    ) {
        val input = Scanner(System.`in`).nextLine()
        when (input) {
            "q" -> onExit
            "0" -> onCreate
            else -> onClick(input.toInt() - 1)
        }

    }
}
