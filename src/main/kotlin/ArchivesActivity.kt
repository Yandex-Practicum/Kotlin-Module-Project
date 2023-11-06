import kotlin.io.path.createTempDirectory

/*Функции:
  - Список существующих архивов
  - 0 = Кнопка "Создать архив"
  - 1 = Возможность выбора архива из списка для просмотра
  - 2 = Кнопка "Выйти", возвращающая на "Главное меню"*/

fun archivesActivity() {
    val items: List<Item> = listOf(
        Item(0,"Создать архив", createArchive()),
        Item(1,"Выбранный архив", archiveDetails()),
        Item(2,"Выйти", createArchive())
        )

    val manager = MenuManager(items)
    while (true) {
        manager.userInputValidation(items)
    }



}