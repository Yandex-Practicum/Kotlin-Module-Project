fun main() {
    val archiveList = ArchiveList() // Список архивов
    var running = true // Условие проверки выхода из программы
    while (running) {
        when (MENU.nav) {
            MENU.ARCHIVE_LIST -> { // Экран 1. Архивы
                Input().navigate(
                    archiveList.menuArchive, // меню: архивы + команды (Визуальный вывод)
                    archiveList.choose, // выбор команды
                )
            }

            MENU.ARCHIVE_CREATE -> {
                Input().create(
                    { println("Введите название нового архива") },
                    archiveList.createArchive
                )
            }

            MENU.NOTE_LIST -> {
                Input().navigate(
                    archiveList.activeNoteList.menuNoteList, //  меню: Заметки + команды (Визуальный вывод)
                    archiveList.activeNoteList.choose, // выбор команды
                )
            }

            MENU.NOTE_CREATE -> {
                Input().create(
                    { println("Введите название новой заметки") },
                    archiveList.activeNoteList.createSome
                )
            }

            MENU.NOTE_SHOW -> { // Экран 3. Заметки
                Input().navigate(
                    archiveList.activeNoteList.activeNote.showMainMenu,
                    archiveList.activeNoteList.activeNote.choose
                )
            }

            MENU.NOTE_EDIT -> {
                Input().create(
                    { println("Дополните заметку") },
                    archiveList.activeNoteList.activeNote.addText
                )
            }

            else -> running = false
        }
    }
}