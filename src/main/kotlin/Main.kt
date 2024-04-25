import java.util.Scanner

object NotesApp {
    val archives = mutableListOf<Archive>()
    private val scanner = Scanner(System.`in`)

    @JvmStatic
    fun main(args: Array<String>) {
        Archive.archiveMenu()
    }

}