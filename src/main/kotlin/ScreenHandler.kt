import java.util.Scanner

open class ScreenHandler {

    private val sc = Scanner(System.`in`)

    protected fun printItems(title: String, list: List<Any>) {
        println(title)
        list.forEachIndexed { index, it ->
            println("${index + 1}. ${it.toString().take(10)}...")
        }
        println("${list.size + 1}. Выход")
    }

    protected fun inputCheck(list: List<Any>): Int {
        while (true) {
            try {
                val input = sc.nextLine().toInt()
                if (input < 0 || input > list.size + 1) {
                    println("Упс! Кажется, произошел промах по цифрам... Давайте еще попробуем")
                } else {
                    return input
                }
            } catch (e: Exception) {
                println("Ой! Ошибочка! Попробуйте ввести цифры от 0 до ${list.size + 1}:")
            }
        }
    }

    protected fun exit() {
        println("Урадавайура!")
        return
    }

    protected fun noteExit() {
        while (sc.hasNext()) {
            if (sc.nextLine() == "0") break
        }
    }
}