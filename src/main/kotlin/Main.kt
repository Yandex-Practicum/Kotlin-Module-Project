import java.util.Scanner

data class Note(val title: String, val content: String)
data class Archive(val name: String, val notes: List<Note> = emptyList())

val archiveList = mutableListOf<Archive>()
val scanner = Scanner(System.`in`)

fun main() {
    println("Добро пожаловать в приложение 'Заметки'!")
    openArchiveMenu()
}

fun readNonEmptyString(prompt: String): String {
    while (true) {
        println(prompt)
        val input = scanner.nextLine().trim()
        if (input.isNotEmpty()) {
            return input
        }
        println("Ошибка: поле не может быть пустым. Попробуйте еще раз.")
    }
}