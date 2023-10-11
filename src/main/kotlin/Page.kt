import java.util.Scanner

open class Page(open var name: String) {

    open fun show(){}
    open fun create(){}
    fun navigate(
        message: String,
        list: MutableList<out Page>,
        //onCreate: () -> Unit,
    )
    {
        while (true) {
            println(message)
            for (i in list)
                println("${list.indexOf(i) + 1}. ${i.name}")

            val input = Scanner(System.`in`).nextLine()
            when (input) {
                "q" -> break
                "0" -> this.create()
                else -> list[input.toInt() - 1].show()
            }
        }
    }
}
