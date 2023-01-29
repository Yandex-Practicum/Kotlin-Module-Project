import java.util.*

class Archive(val name: String, val source: StartMenu): Menu() {
    val content: MutableMap<String, Note> =  mutableMapOf()
    val navigator = Navigation()
    fun newNote() {
        println("Введите имя заметки, нажмите Enter и введите содержимое заметки")
        val newNote = Note(Scanner(System.`in`).nextLine(), Scanner(System.`in`).nextLine(), this)
        content.put(newNote.name, newNote)
        menu.put("Открыть заметку ${newNote.name}", {navigator.show(content[newNote.name]!!)})

    }

  //  override val menu: MutableMap<String, () -> Unit> = mutableMapOf()

}


