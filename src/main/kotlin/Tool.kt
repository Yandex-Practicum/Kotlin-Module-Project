import java.util.*

abstract class Tool {
    open val phrase1 = ""
    open val phrase2 = ""
    private val scanner = Scanner(System.`in`)
    open var beforeInput: Int = 0

    open fun textOfMenu(phrase1: String, phrase2: String) {
        println("Выберите следующее действие:")
        println("1 - Посмотреть $phrase1")
        println("2 - Создать $phrase2")
        println("0 - Выход ")
    }

    fun preCheck(scanner: Scanner): Int {
        val proverka = scanner.nextInt()
        return proverka
    }

    fun check(beforeInput: Int) {
        if (scanner.hasNextInt()) {
            this.beforeInput = preCheck(scanner)
        } else {
            Error.errorOfScanner()
        }
    }

    open fun createOne() {

    }

}



