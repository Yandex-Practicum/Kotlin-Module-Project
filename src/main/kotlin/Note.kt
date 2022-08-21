import java.util.*

class Note(val name: String, val content: String) {

    override fun toString(): String {
        return name
    }

    fun showNote() {
        for (i in 0..EMPTY_STRING_NUMBERS) {                          // имитируем новый экран
            println()
        }

        println(name.uppercase())
        println(content)

        val scanner: Scanner = Scanner(System.`in`)
        println()
        println("Для возвращения к архиву введите любой символ и нажмите Enter")

        if (scanner.nextLine() != "") return
    }

    //val content: String = Scanner(System.`in`).nextLine()

    //fun createNote () {
    //    println("Введите название заметки")
    //    val name: String = Scanner(System.`in`).next()
    //    println("Введите текст заметки")
    //    val content: String = Scanner(System.`in`).next()
    //}
}