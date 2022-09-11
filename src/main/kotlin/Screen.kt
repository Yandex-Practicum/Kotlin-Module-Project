sealed class Screen {
    object ShowAllArchives : Screen() {
        const val MENU_TITLE = "ВСЕ АРХИВЫ"
        const val MENU_BUTTON_0 = "0. Создать архив"
    }

    class ShowArchive(val archive: Archive) : Screen() {
        val MENU_TITLE = "АРХИВ"
        val MENU_BUTTON_0 = "0. Создать заметку"
    }

    class ShowNote(val note: Note) : Screen() {
        val MENU_TITLE = "Заметка"
    }

    object CreateArchive : Screen() {
        val MENU_TITLE = "СОЗДАНИЕ АРХИВА"
        val ENTER_NAME = "Введите название архива: "
    }

    class CreateNote(val archive: Archive) : Screen() {
        val MENU_TITLE = "СОЗДАНИЕ ЗАМЕТКИ"
        val ENTER_NOTE_TITLE = "Введите название заметки: "
        val ENTER_NOTE_TEXT = "Введите текст заметки: "
    }

    val EXIT = "Выход"
    val ANY_KEY = "Любая клавиша"
}