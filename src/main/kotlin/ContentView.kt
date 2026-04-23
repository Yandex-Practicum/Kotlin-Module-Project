import java.util.Scanner

class ContentView(
    private val note: Note
) {
    fun show() {
        println("\n===${note.nameNote}===")
        println("-".repeat(40))
        println(note.textNote)
        println("_".repeat(40))
        println("Нажмите Enter, что бы вернуться...")
        Scanner(System.`in`).nextLine()
    }
}