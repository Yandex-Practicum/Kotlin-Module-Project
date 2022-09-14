data class MenuResources (val st: ScreenType) {
    val screenCaption: String
    val listIsEmpty: String
    val addNewItem: String
    val exitScreen: String
    val inputErrorOnEmptyList: String
    val inputErrorOnFilledList: String
    val selectMenuItem: String = "Выберите пункт меню"

    init {
        when (st) {
            ScreenType.MAIN -> {
                screenCaption = "Главный экран - список архивов"
                listIsEmpty = "(список архивов пока пуст)"
                addNewItem = "добавить новый архив"
                exitScreen = "выйти из программы"
                inputErrorOnEmptyList = "Ошибка! Необходимо ввести 'a' для добавления нового архива или 'q' для выхода"
                inputErrorOnFilledList = "Ошибка! Необходимо ввести номер архива, 'a' для добавления нового архива или 'q' для выхода"
            }
            ScreenType.ARCHIVE -> {
                screenCaption = "Архив '%s' - список заметок"
                listIsEmpty = "(список заметок пока пуст)"
                addNewItem = "добавить новую заметку"
                exitScreen = "выйти из архива"
                inputErrorOnEmptyList = "Ошибка! Необходимо ввести 'a' для добавления новой заметки или 'q' для выхода"
                inputErrorOnFilledList = "Ошибка! Необходимо ввести номер заметки, 'a' для добавления новой заметки или 'q' для выхода"
            }
        } //> when
    } //> init
}

enum class ScreenType {
    MAIN, ARCHIVE
}