import java.util.*
import kotlin.collections.ArrayList

open class Menu<T> {

    open var first: String = ""

    val collection: ArrayList<T> = ArrayList()

    open fun execute() {

    }
    fun menu() {
        println("0. $first")

        var iterator: Int = 1
        collection.forEach { element ->
            println("$iterator. $element")
            iterator++
        }

        println("${collection.size + 1}. Выход")

    }

    fun input(): Int {
        while (true) {
            val scanner = Scanner(System.`in`)
            try {
                val input = scanner.nextInt()
                if (input > collection.size + 1) {
                    println("Несуществующая команда, выберите цифру из меню")

                } else {
                    return input
                }


            } catch (e: InputMismatchException) {
                println("Введите цифру меню")
            }
        }
    }
}

