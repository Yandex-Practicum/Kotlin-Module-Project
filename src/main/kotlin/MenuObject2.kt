import java.util.*

abstract class MenuObject2<T> (val firstElement: String, val lastElement: String) {

    var collection: ArrayList<T> = ArrayList()

    fun createMenu() {

        //println("Введите название")

        val menuList: HashMap<Int, String> = HashMap()
        menuList.put(0, firstElement)

        var iterator = 1
        //перебор коллекции и заполнение меню

        menuList.put(iterator, lastElement)

        //val input = Scanner(System.`in`).nextLine()
        //elements.put(1 to input)

        //извлечение команды

    }

    fun showMenu(name: String, elements: HashMap<Int, String>) {
        println(name)
        for (element in elements)
            println("${element.key}. ${element.value}")

        userInput(elements)
    }

    fun userInput(elements: HashMap<Int, String>) {
        println("Введите номер пункта")

        while (true) {
            val input: Int
            try {
                input = Scanner(System.`in`).nextLine().toInt()
            } catch (e: NumberFormatException) {
                println("Ошибка! Введите число.")
                for (element in elements)
                    println("${element.key}. ${element.value}")
                continue
            }

            if (!elements.containsKey(input)) {
                println("Ошибка! Вы ввели номер, отсутствующий в списке. Введите корректный номер пункта.")
                for (element in elements)
                    println("${element.key}. ${element.value}")
                continue
            } else {
                when (input) {
                    0 -> createElement()
                    in 1..(elements.size - 2) -> continue
                    (elements.size - 1) -> break
                }
                break
            }
        }

        for (element in elements)
            println("${element.key}. ${element.value}")
    }

    fun createElement () {

    }

    fun executeCommand (index: Int, elements: HashMap<Int, String>) {
        var command = elements.getValue(index)


    }
}