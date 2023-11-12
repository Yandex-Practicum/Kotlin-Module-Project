import kotlin.system.exitProcess

fun main() {
    val menuManager = MenuManager()
    MainMenuActivity(menuManager).start()

}
class MainMenuActivity(private val menuManager: MenuManager) {
    fun start() {
        val options = listOf("Старт", "Выход")
        menuManager.showMenu(options)
        val input = menuManager.getUserInput()
        when (input) {
            1 -> ArchivesActivity(menuManager).start()
            2 -> { exitProcess(0) }
            else -> println("Выберите номер еще раз.")
        }
    }
}