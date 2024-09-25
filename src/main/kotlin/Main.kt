import java.util.InputMismatchException
import java.util.Scanner

fun main() {
    println("Добро пожаловать в приложение заметки!")
    var library = Library()
    val navigator = Navigator()
    var archive = Archive("")

    //navigation menu
    navigator.showMenu("Главное меню", listOf())
}
fun getTextInput(): String {
    val scanner = Scanner(System.`in`)
    var input = scanner.nextLine()
    while (input.trim().isEmpty()) {
        println("Поле не может быть пустым")
        input = scanner.nextLine()
    }
    return input
}

    fun getNumInput(): Int {
        println("Введите число: ")
        val scanner = Scanner(System.`in`)
        while (true) {
            try {
                return scanner.nextInt()
            } catch (e: InputMismatchException) {
                println("Ошибка ввода. Пожалуйста, введите число.")
                scanner.next()
            }
        }
    }


