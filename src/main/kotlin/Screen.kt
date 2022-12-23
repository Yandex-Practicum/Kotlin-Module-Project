abstract class Screen<out T>(private val name_accusative: String, private val dataList: MutableList<T>)  {

    fun show() {
        while (true) {
            println("Выберите действие:\n0. Создать $name_accusative")
            if (dataList.isNotEmpty()) {
                dataList.forEachIndexed { index, elem -> println("${index + 1}. Открыть $name_accusative $elem") }
            } else {
                println("Нет элементов! Создайте $name_accusative, чтобы увидеть список.")
            }
            println("${dataList.size + 1}. Выход")
            when (val action: Int? = readLine()!!.toIntOrNull()) {
                0 -> add()
                in 1..dataList.size -> select(action!!)
                dataList.size + 1 -> back()
                null -> println("Ошибка ввода: ожидалось число")
                else -> println("Ошибка ввода: введено недопустимое число")
            }
        }
    }

    abstract fun add()
    abstract fun select(id: Int)
    abstract  fun back()

}