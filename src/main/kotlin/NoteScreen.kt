import java.util.Scanner

object NoteScreen {
    fun showNote(note: Note) {
        println("ПРОСМОТР ЗАМЕТКИ:")
        println("\tНазвание заметки: ${note.name}")
        println("\tТекст заметки: ${note.text}")
        println("Для продолжения работы нажмите Enter:")
        val s = Scanner(System.`in`).nextLine()
        if (s is String) {
            ArchiveSelectionScreen.menuOutput()
        }
    }
}