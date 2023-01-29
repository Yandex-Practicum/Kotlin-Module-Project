import java.util.Scanner

class Note(
    val name: String,
    var contain: String,
    val source: Archive
): Menu() {
    //val menu: MutableMap<String, () -> Unit> = mutableMapOf()
   // override val menu: MutableMap<String, () -> Unit> = mutableMapOf()

    fun showNote() {
        println("Название заметки: $name\nТекст заметки: $contain")
    }

    fun changeNote() {
        println("Введите новый текст заметки:")
        contain = Scanner(System.`in`).nextLine()
        return
    }
}