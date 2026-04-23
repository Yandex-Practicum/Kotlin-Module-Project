import java.util.Scanner


class CreateScreen(
    private val itemType: String
) {
    companion object {
        private val scanner = Scanner(System.`in`)
    }

    fun show(): CreateResult {
        println("\nСоздание $itemType")
        print("Введите название $itemType: ")
        val name = scanner.nextLine().trim()
        if (name.isEmpty()) {
            println("Ошибка: название не может быть пустым")
            return CreateResult.Cancelled
        }
        if (itemType == "заметки") {
            print("Введите текст заметки: ")
            val text = scanner.nextLine().trim()
            if (text.isEmpty()) {
                println("Ошибка: текст заметки не может быть пустым")
                return CreateResult.Cancelled
            }
            return CreateResult.NoteCreated(name, text)
        }
        return CreateResult.ArchiveCreated(name)
    }

}

sealed class CreateResult {
    object Cancelled : CreateResult()
    data class ArchiveCreated(val name: String) : CreateResult()
    data class NoteCreated(val name: String, val text: String) : CreateResult()

}