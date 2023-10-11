import java.util.Scanner

open class Page(open var name: String) {
    fun navigate(
        message: String,
        list: MutableList<out Page>,
        onCreate: () -> Unit,
        onClick: (value: Int) -> Unit
    ) {
        while (true) {
            println(message)
            for (i in list)
                println("${list.indexOf(i) + 1}. ${i.name}")

            val input = Scanner(System.`in`).nextLine()
            when (input) {
                "q" -> break
                "0" -> onCreate()
                else -> onClick(input.toInt() - 1)
            }
        }
    }
}
