enum class TypeMenu {
    START_MENU,
    CHOOSER_MENU,
    ARCHIVES_MENU,
    CREATE_NOTE_NAME_MENU,
    CREATE_NOTE_TEXT_MENU,
    NOTE_IS_SHOWN_MENU,
    CREATE_ARCHIVE_MENU;

    fun getTextMenu() {
        when (this) {
            START_MENU -> println("1 - Создать архив \n2 - Войти в архив\n0 - Выход")
            CHOOSER_MENU -> println("Введи порядковый номер:")
            ARCHIVES_MENU -> println("1 - Создать заметку в этом архиве \n2 - Просмотреть заметку\n0 - Назад")
            CREATE_NOTE_NAME_MENU -> println("^^^\nСоздание заметки. Введи название или 0 - назад в меню")
            CREATE_NOTE_TEXT_MENU -> println("Название получено. Введи текст заметки")
            NOTE_IS_SHOWN_MENU -> println("---\n1 - Добавить текст в эту заметку\n0 - назад в список заметок")
            CREATE_ARCHIVE_MENU -> println("Создание архива. Введи название архива или 0 - назад в меню")
        }
    }
}