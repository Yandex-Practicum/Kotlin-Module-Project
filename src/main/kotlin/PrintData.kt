abstract class PrintData {
    fun printHeader(text: String, isMain: Boolean) {
        if (isMain)
            println("=================")
        else
            println("-----------------")

        println(text)
        println("-----------------")
    }

    fun printError(number: String) {
        printHeader("Введено некорретное число: $number", false)
    }
}