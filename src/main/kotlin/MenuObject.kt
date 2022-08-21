import java.util.*

abstract class MenuObject<T> (val firstElement: String, val lastElement: String) {

    abstract val name: String

    var collection: HashMap<Int, Any> = HashMap()

    init {
        collection.put(0, firstElement)
        collection.put(1, lastElement)
    }



        /*fun createMenu() {

        collection.put(0, firstElement)

        var iterator = 1
        for (item in collection) {
            collection.put(iterator, name)
            iterator++
        }

        collection.put(collection.size, lastElement)

        showMenu(collection)
    }*/

    fun showMenu() {
        for (i in 0..20) {                          // имитируем новый экран
            println()
        }

        println(name.uppercase())

        for (element in collection) {

            if (element.value is String) { println("${element.key}. ${element.value}") }
            else {
                val elementName = element.value.toString()
                println("${element.key}. ${elementName}")
            }

        }

        userInput(collection)
    }

    fun userInput(elements: HashMap<Int, Any>) {
        println("Введите номер пункта:")

        while (true) {
            val input: Int
            try {
                input = Scanner(System.`in`).nextLine().toInt()
            } catch (e: NumberFormatException) {
                for (i in 0..EMPTY_STRING_NUMBERS) {                          // имитируем новый экран
                    println()
                }
                println("Ошибка! Введите число.")
                println(name.uppercase())
                for (element in elements)
                    println("${element.key}. ${element.value}")
                continue
            }

            if (!elements.containsKey(input)) {
                for (i in 0..EMPTY_STRING_NUMBERS) {                          // имитируем новый экран
                    println()
                }
                println("Ошибка! Вы ввели номер, отсутствующий в списке. Введите корректный номер пункта.")
                println(name.uppercase())
                for (element in elements)
                    println("${element.key}. ${element.value}")
                continue
            } else {
                when (input) {
                    0 -> createElement()
                    in 1..(elements.size - 2) -> openElement(input)
                    (elements.size - 1) -> exit()
                }
                break
            }
        }
    }

    abstract fun createElement ()

    abstract fun exit()

    abstract fun openElement(elementNumber: Int)


}