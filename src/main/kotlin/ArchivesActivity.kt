/*Функции:
  - Список существующих архивов
  - 0 = Кнопка "Создать архив"
  - 1 = Возможность выбора архива из списка для просмотра
  - 2 = Кнопка "Выйти", возвращающая на "Главное меню"*/

class ArchivesActivity {

    val items: MutableList<Item> = mutableListOf(
        Item(0,"Создать архив") { CreateArchiveActivity().start() },
        Item(1,"Выбранный архив") { ArchiveDetailsActivity().start() },
        Item(2,"Выйти") { main() }
    )
    private val menuManager = MenuManager(items)
    val archives: MutableList<Archive> = mutableListOf()
    fun start() {
        archivesShow()
        while (true) {
            menuManager.showMenu()
            when(menuManager.getUserInput()) {
                0 -> items[0].inten
                1 -> items[1].inten
                2 -> items[2].inten
            }
        }
    }
    fun archivesShow() {
        println("Архивы -------------------------------------------------------")
        for (element in archives) {
            println("архив: ${element.title} - ${element.count} заметок")
        }

    }

}




