import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class NoteCreationScreen : Screen<Any?>() {
    override fun show() {
        print("Введите название новой заметки: ")
        val noteName = scanner.nextLine()
        if (noteName.isEmpty()) {
            println("Название заметки не может быть пустым.")
            return
        }

        print("Введите текст новой заметки: ")
        val noteText = scanner.nextLine()

        val noteFullName = "$noteName ${LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm"))}"

        archives[currentArchive]?.put(noteFullName, noteText)
    }
}