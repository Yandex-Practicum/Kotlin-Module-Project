import java.util.Scanner

open class Sample {

    val map: MutableMap<String, Parent> = mutableMapOf()
    var counter = 1
    private var countExit = 1
    open val word = ""
    open val exit = ""
    fun processInp() {
        while (true) {
            printMenu()
            val inp = Scanner(System.`in`).nextLine()
            try {
                inp.toInt()
            } catch (e: NumberFormatException) {
                println("Вы ввели не число или не ввели ничего. Попробуйте заново.")
                continue
            }
            when (inp) {
                "0" -> {
                    create()
                }

                countExit.toString() -> return
                else -> checkIf(inp)
            }
        }
    }

    fun decoration() {
        println(" ")
        for (i in 0..100) print("=")
        println(" \n")
    }

    private fun printMenu() {
        decoration()
        println("Список $word :\n0.Создать $word")
        map.forEach { (key, value) -> println("$key.${value.name}") }
        println("$countExit.<- $exit")
        println("Введите команду :")
    }

    private fun create() {
        var name: String
        decoration()
        while (true) {
            println("Введите имя $word :")
            name = Scanner(System.`in`).nextLine()
            if (name.isEmpty()) {
                println("Имя не может быть пустым.")
            } else break
        }
        val text = makeText()
        makeInstance(name, text)
        counter++
        println("Создание прошло успешно!")
        countExit++
    }

    open fun makeInstance(name: String, text: String) {
    }

    open fun makeText(): String {
        var text: String
        while (true) {
            println("Введите текст заметки :")
            text = Scanner(System.`in`).nextLine()
            if (text.isEmpty()) {
                println("Заметка не может быть пустая. Напишите что-нибудь.")
            } else break
        }
        return text
    }

    open fun checkIf(a: String) {
        if (a in map.keys) {
            map[a]?.processInp()
        } else {
            println("Такой команды нет.")
        }
    }

}