class InitialMenu {
    private val mainMenu: MutableList<MenuFields> = mutableListOf(
        Archive(0, "Выйти"),
        Archive(1, "Создать архив")
    )

    fun start() {
        while (true) {
            if (NaviFunctions.push(
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