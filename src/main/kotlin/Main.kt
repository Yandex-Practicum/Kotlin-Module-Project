import java.util.InputMismatchException
import java.util.Scanner

fun main() {
    println("Добро пожаловать в приложение заметки!")
    var library = Library()
    val navigator = Navigator()
    var archive = Archive("")

    //navigation menu
    navigator.navigateMenu(library)

}

fun getTextInput(): String {
    var input = Scanner(System.`in`).nextLine()
    while (input.trim().isEmpty()) {
        println("Поле не может быть пустым")
        var input = Scanner(System.`in`).nextLine()
    }
    return input
}

fun getNumInput(): Int {
    val scanner = Scanner(System.`in`)
    while (true) {
        //println("Введите число: ")
        try {

            return scanner.nextInt()
        } catch (e: InputMismatchException) {
            println("Ошибка ввода. Пожалуйста, введите число.")
            scanner.next()
        }
    }
}
