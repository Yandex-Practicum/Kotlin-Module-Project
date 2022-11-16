class InitialMenu {
    private val mainMenu: MutableList<MenuFields> = mutableListOf(
        Archive(0, "Выйти"),
        Archive(1, "Создать архив")
    )

    private val naviFunctions = NaviFunctions()

    fun start() {
        while (true) {
            if (naviFunctions.push(
                    mainMenu,
                    "Главное меню",
                    "Архив",
                    "Работа приложения завершена"
                )
            )
                return
        }
    }
}