/*Функции:
  - Список существующих архивов
  - 0 = Кнопка "Создать архив"
  - 1 = Возможность выбора архива из списка для просмотра
  - 2 = Кнопка "Выйти", возвращающая на "Главное меню"*/

class ArchivesActivity (private val menuManager: MenuManager ) {
    private val archives = ArchiveManager.archives

    fun start() {
        val options = mutableListOf("Создать архив").apply {
            addAll(archives.map { it.name })
            //add("Создать архив")
            add("Выйти")
        }
        menuManager.showMenu(options)
        val input = menuManager.getUserInput()

        when (input) {
            1 -> CreateArchiveActivity(archives, menuManager).start()
            in 1..archives.size -> ArchiveDetailsActivity(archives[input - 1], menuManager).start()
            archives.size + 2 -> MainMenuActivity(menuManager).start()
            else -> println("Повторите свой выбор.")
        }
    }

}




