import java.util.Scanner

class Adapter {

    fun greet() {
        while (true) {
            val input = Scanner(System.`in`).nextLine()
            when (input) {
                "0" -> {
                    println("Bye!")
                    break
                }

                "1" -> {
                    println("Переход к списку архивов")
                }//goto archive list


                "2" -> {
                    println("Создать новый архив")
                }//create new archive"


                else -> {
                    println("Неизвестная команда. Повторите ввод")
                    return
                }
            }
        }
    }
}