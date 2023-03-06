import java.util.Scanner

fun createNote(): Note {

    println("Введите название заметки:")

    while (true) {

        val input = readLine()
        // делаем проверки
        when {
            input == null -> println("Упс. Что-то пошло не так. Попробуйте еще раз.")
            input.isEmpty() -> println("Ничего не введено. Попробуйте еще раз.")
            else -> {
                val inputText = Scanner(System.`in`).nextLine()
                return  Note(input, inputText)
            }
        }
    }
}