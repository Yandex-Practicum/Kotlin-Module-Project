import presenter.Presenter
import view.AllArchiveScreen
import view.ArchiveCreationScreen
import view.MainScreen
import view.Screen
import java.util.*
import kotlin.collections.ArrayDeque



fun main() {
    val scanner = Scanner(System.`in`)
    val presenter = Presenter()
    val stack = ArrayDeque<Screen>()

    val mainScreen = MainScreen(presenter)
    val allArchivesScreen = AllArchiveScreen(presenter)
    val archiveCreationScreen = ArchiveCreationScreen(presenter)

    stack.addFirst(mainScreen)

    while (stack.isNotEmpty()) {
        if (stack.size > 1) {
            stack.removeLast()
        }
        stack.last().show()
        when (scanner.nextLine()) {
            "0" -> {
                println("Bye Bye...")
                stack.removeAll(stack)
                return
            }

            "1" -> {
                stack.add(allArchivesScreen)
                allArchivesScreen.show()
            }

            "2" -> {
                stack.add(archiveCreationScreen)
                archiveCreationScreen.show()
            }
        }
    }
}
