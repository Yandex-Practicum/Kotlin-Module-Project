import java.lang.Exception
import java.util.*
import kotlin.system.exitProcess

object GetStarted {

    private val scanner = Scanner(System.`in`)
    private val archiveList = mutableListOf<Archives>()

    fun startedFunction(screen: Screen) {
        when (screen) {
            is Screen.MainScreen -> {
                println("The current folder is Archives.\n0. -> press to create archive.")
                nameOfArchiveAndNumberOfExit(archiveList)
                checkCheck()
                val number: Int = scanner.nextInt()
                if (number > archiveList.size + 1) {
                    println("The number must be till ${archiveList.size + 1}")
                    startedFunction(Screen.MainScreen)}
                when (number) {
                    0 -> startedFunction(Screen.CreateArchive)
                    archiveList.size + 1 -> {
                        println("See you!")
                        exitProcess(0)
                    }
                    number -> {startedFunction(Screen.OpenArchive(archiveList[number-1]))}
                }
            }

            is Screen.CreateArchive -> {
                println("Name the archive")
                val nameOfArchive = readLine().toString()
                archiveList.add(Archives(nameOfArchive))
                startedFunction(Screen.MainScreen)
            }

            is Screen.OpenArchive -> {
                println("Archive: ${screen.archives.name}.\n0. -> press to create note.")
                nameOfArchiveAndNumberOfExit(screen.archives.note)
                checkCheck()
                val number: Int = scanner.nextInt()
                if (number > screen.archives.note.size + 1) {
                    println("The number must be till ${screen.archives.note.size + 1}")
                    startedFunction(Screen.OpenArchive(screen.archives))
                }
                when (number) {
                    0 -> startedFunction(Screen.CreateNote(screen.archives))
                    screen.archives.note.size + 1  -> startedFunction(Screen.MainScreen)
                    else -> startedFunction(Screen.ShowNote(screen.archives.note[number-1]))
                }
            }

            is Screen.CreateNote -> {
                println("Name the note")
                val title = readLine().toString()
                println("Fill the note")
                val text = readLine().toString()
                screen.archives.note.add(Note(title, text, screen.archives))
                startedFunction(Screen.OpenArchive(screen.archives))
            }

            is Screen.ShowNote -> {
                println("Note: ${screen.note.title}.\nText: ${screen.note.text}.\nPress any key to exit")
                readLine().toString()
                startedFunction(Screen.OpenArchive(screen.note.archive))
            }
        }
    }

    private fun checkCheck() {
        try {
            while (!scanner.hasNextInt()) {
                println("Enter a numeric value.")
                scanner.next()
            }
        } catch (e: Exception) {
            println("Enter a numeric value.")
        }
    }
}