import model.Archive
import navigation.NavController
import navigation.SelectArchive

object NoteTakingApp {
    val archives: MutableList<Archive> = mutableListOf()
    val navController = NavController(this)

    fun launch() {
        navController.navigateTo(SelectArchive())

        while (!navController.isEmpty()) {
            if (!navController.currentScreen().handleInput()) {
                navController.navigateBack()
            }
        }
        println("Goodbye")
    }

    fun addArchive(title: String) {
        archives.add(Archive(title))
    }
}

