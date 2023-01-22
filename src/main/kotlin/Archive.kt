import java.util.*

/*
класс Архив содержит поле название архива, и контент - изменяемый список заметок.
заметки first и second введены для тестов, чтобы можно было посмотреть на работу функции showContent
функция showContent в перспективе предположительно должна использоваться для создания меню
*/

class Archive(
    val name: String
) {
    val content: MutableList<Note> = mutableListOf()
    val menu: MutableList<String> = mutableListOf("Создать заметку", "Выйти в меню архивов")

    fun newNote() {
        println("Введите имя заметки, нажмите Enter и введите содержимое заметки")
        val newNote = Note(Scanner(System.`in`).nextLine(), Scanner(System.`in`).nextLine())
        content.add(newNote)
        menu.add(newNote.name)
    }

    fun showMenu() {
        println("Выберите пункт меню:")
        for(i in menu) {
            println("${menu.indexOf(i)}: $i")
        }
    }
    fun showNotes(index: Int) {
        when(index) {
            0 -> newNote()
            1 -> return
            in 2..menu.size - 1 -> content.elementAt(index-2).showNote()
        }
    }
}