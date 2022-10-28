import java.util.*
import kotlin.collections.HashMap

class Archive(val _name: String) : MenuObject<Note>() {

    override var FIRST: String = "Создать заметку"
    override var LAST: String = "Вернутся к архивам"

    val name: String = _name;

    fun createNote() {

        val sc: Scanner = Scanner(System.`in`)

        println("Введите имя заметки")
        var name = sc.nextLine()

        println("Введите содержание заметки")
        var content = sc.nextLine()

        collection.add(Note(name, content))

    }

    override fun toString(): String {
        return name
    }

    override fun executeCommand(index: Int, hs: HashMap<Int, String>) {

        var command = hs.getValue(index);

        when (command) {
            "Вернутся к архивам" -> return
            "Создать заметку" -> createNote()
            else ->

                println("Ваша заметка -> " + collection.find { note -> note.nameNote == command }
                    ?.note)

        }
        createMenu()


    }


}
