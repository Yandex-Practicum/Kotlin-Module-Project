class MainMenu {
    private val mainMenu: MutableList<MenuFields> = mutableListOf(
        Archive(0, "Выйти"),
        Archive(1, "Создать архив")
    )

    private val bestFunctions = BestFunctions()

    fun start() {
        while (true) {
            if(bestFunctions.push(mainMenu, "Главное меню","архив", "Работа приложения завершена"))
                return
        }
    }
}