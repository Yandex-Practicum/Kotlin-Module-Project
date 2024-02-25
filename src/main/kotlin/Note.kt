import java.util.Scanner

open class Note (override val name:String, private val text: String): Parent {
    override fun processInp() {
        val deco = Sample()
        deco.decoration()
        println(text)
        println("\n<- Чтобы вернуться назад нажмите на любую клавишу.")
        Scanner(System.`in`).nextLine()

    }
}