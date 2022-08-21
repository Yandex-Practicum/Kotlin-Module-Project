import java.util.*

class Archive(override val name: String) : MenuObject<Note> ("Создать заметку", "Назад к архивам") {

    override fun toString(): String {
        return name
    }

    override fun createElement () {
        for (i in 0..EMPTY_STRING_NUMBERS) {                          // имитируем новый экран
            println()
        }

        val scanner: Scanner = Scanner(System.`in`)

        println("Введите название заметки:")
        var name: String = scanner.nextLine()

        println("Введите текст заметки:")
        var content: String = scanner.nextLine()

        collection.put(collection.size, lastElement)
        collection.put(collection.size - 2, Note(name, content))

        showMenu()
    }

    override fun exit() {
        archiveList.showMenu()
    }

    override fun openElement(elementNumber: Int) {
        for (i in 0..EMPTY_STRING_NUMBERS) {                          // имитируем новый экран
            println()
        }

        val showedElement = collection.getValue(elementNumber)

        if (showedElement is Note) {
            showedElement.showNote()
        }

        showMenu()
    }

}