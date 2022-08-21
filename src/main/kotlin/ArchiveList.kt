import java.util.*

class ArchiveList(override val name: String = "Список архивов") : MenuObject<Archive> ("Создать архив", "Выход из программы") {

    override fun toString(): String {
        return name
    }

    override fun createElement () {
        for (i in 0..EMPTY_STRING_NUMBERS) {                          // имитируем новый экран
            println()
        }

        val scanner: Scanner = Scanner(System.`in`)

        println("Введите имя архива:")
        var archiveName: String = scanner.nextLine()

        collection.put(collection.size, lastElement)
        collection.put(collection.size - 2, Archive(archiveName))

        showMenu()
    }

    override fun exit() {
        return
    }

    override fun openElement(elementNumber: Int) {
        for (i in 0..EMPTY_STRING_NUMBERS) {                          // имитируем новый экран
            println()
        }

        val showedElement = collection.getValue(elementNumber)

        if (showedElement is Archive) {
            showedElement.showMenu()
        }

    }


}