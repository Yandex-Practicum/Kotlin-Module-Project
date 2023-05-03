import java.util.*

class Archive(override var name: String): Screen() {

    var listObjects: MutableList<Note> = mutableListOf()
    override val createObject: String = "заметку"

    override fun showObjects() {
        while (true) {
            Show(listObjects).show(createObject)
            if (InCommand().executeCommand(this, listObjects) == overModule) {
                break
            }
        }
    }

    override fun addObject() {
        println("Введите название заметки: ")
        val nameNote = Scanner(System.`in`).nextLine()
        println("Введите текст заметки: ")
        val textNote = Scanner(System.`in`).nextLine()

        listObjects.add(Note(nameNote, textNote))
        println("Заметка $nameNote создана.")

    }
}