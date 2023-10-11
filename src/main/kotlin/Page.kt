import java.util.Scanner

open class Page(open var name: String) {

    open fun show() {}
    open fun create() {}
    private val toExit: String = if (this is MainPage) "Выйти из программы"
    else "В предыдущее меню"

    fun navigate(
        list: MutableList<out Page>,
    ) {
        while (true) {

            println(
                "$name\n" +
                        "0. Создать $this"
            )

            for (i in list)
                println("${list.indexOf(i) + 1}. ${i.name}")

            println("${list.lastIndex + 2}. $toExit")

                var input = -1//начало обработки ошибок
                val scanner = Scanner(System.`in`)
                if (scanner.hasNextInt()) {
                    input = scanner.nextInt()
                        if (input > (list.lastIndex + 2)){
                            println("Такого пункта нет в списке!")
                            continue
                        }
                } else {
                    println("Введите цифру согласно пунктам меню!")
                    continue
                }//конец обработки ошибок

                when (input) {
                    list.lastIndex + 2 -> break
                    0 -> this.create()
                    else -> list[input - 1].show()
                }

        }
    }
}
