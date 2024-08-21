import java.util.Scanner

fun menuCreateNote(): Note{
    var noteName = ""
    while(true){
        println("Введите название заметки:")
        val input = Scanner(System.`in`).nextLine()
        if (input.isBlank()) println("Пустое название заметки недопустимо.")
        else {
            noteName = input
            break
        }
    }
    return Note(noteName, "")
}
