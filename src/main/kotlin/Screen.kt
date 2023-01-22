import java.util.Scanner

abstract class Screen<T>(private val name : String, private val list : MutableList<T>) {
    fun show() {
        while (true) {
            println("Выберите действие:\n0 - Создать $name.\nДля выбора объекта из существующих введите его номер\nДля выхода из текущего меню введите ${list.size+1}")
            if (list.isNotEmpty()) {
                list.forEachIndexed { index, element -> println("${index+1}. Открыть $name $element")}
                } else {
                    println("Список пуст. Создайте хотя бы один объект $name.")
            }
            when (val action : Int = Scanner(System.`in`).nextInt()) {
                0 -> add()
                in 1..list.size -> select(action)
                list.size+1 -> goBack()
                else -> println("Введенное значение недопустимо. Введите целое значение от 0 до ${list.size+1}")

            }
        }
    }

    abstract fun add()
    abstract fun select(i : Int)
    abstract fun goBack()

}