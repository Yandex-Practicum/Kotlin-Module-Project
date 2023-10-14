import java.util.Scanner

open class Page(open var name: String) {

    open fun show() {}
    open fun create() {}

    fun checkEmpty(text: String): Boolean {
        return if (text.isEmpty()) {
            println("Это поле не может быть пустым.")
            true
        } else {
            false
        }
    }

    private fun getCreatingName(): String {
        return when (this) {
            is MainPage -> "архив"
            is Archive -> "заметку"
            else -> name
        }
    }

    fun isDigit(scanner: Scanner): Boolean {
        return if (scanner.hasNextInt()) {
            true
        } else {
            println("Введите цифру согласно пунктам меню.")
            false
        }
    }

    fun hasPoint(number: Int, input: Int): Boolean {
        return if ((input > number) || (input < 0)) {
            println("Такого пункта нет в списке.")
            false
        } else {
            true
        }
    }

    private val toExit: String = if (this is MainPage) "Выйти из программы"
    else "В предыдущее меню"

    fun navigate(
        list: MutableList<out Page>,
    ) {

        while (true) {
            val lastPointOfMenu = list.lastIndex + 2
            println(
                "$name\n0. Создать ${getCreatingName()}"
            )

            for (i in list) println("${list.indexOf(i) + 1}. ${i.name}")

            println("${lastPointOfMenu}. $toExit")

            var input: Int//начало обработки ошибок
            val scanner = Scanner(System.`in`)
            if (scanner.hasNextInt()) {
                input = scanner.nextInt()
                if ((input > lastPointOfMenu) || (input < 0)) {
                    println("Такого пункта нет в списке.")
                    continue
                }
            } else {
                println("Введите цифру согласно пунктам меню.")
                continue
            }//конец обработки ошибок

            when (input) {
                lastPointOfMenu -> break
                0 -> this.create()
                else -> list[input - 1].show()
            }

        }
    }
}
