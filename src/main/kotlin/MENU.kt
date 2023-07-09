object MENU {
    const val ARCHIVE_LIST: Int = 11   // Архивы
    const val ARCHIVE_CREATE: Int = 12 // Открыть архив
    const val NOTE_CREATE: Int = 21    // Создать заметку
    const val NOTE_LIST: Int = 22      // Выбрать заметку
    const val NOTE_SHOW: Int = 23      // Посмотреть заметку
    const val NOTE_EDIT: Int = 24      // Добавить текст в заметку
    const val EXIT: Int = 0              //Выход из программы
    var nav: Int = this.ARCHIVE_LIST   // В nav храним навигацию по архивам
}

