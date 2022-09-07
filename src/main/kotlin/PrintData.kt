import java.util.Scanner

abstract class PrintData {
    fun printHeader(text: String, isMain: Boolean) {
        if (isMain)
            println("=================")
        else
            println("-----------------")

        println(text)
        println("-----------------")
    }

    fun askAction(): String {
        val scanner = Scanner(System.`in`)
        println("Введите номер подпункта меню:")
        val number = scanner.nextLine()
        return number;
    }

    fun askActionWithExit(text: String): String {
        println("$text (или 'q' для отмены)")
        val scanner = Scanner(System.`in`)
        val number = scanner.nextLine()
        return number;
    }
}