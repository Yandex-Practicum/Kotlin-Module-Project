/*Функции:
  - Просмотр содержимого выбранного из списка  ArchivesActivity архива
  - 0 = Кнопка "Создать заметку" в архиве
  - 1 = Возможность выбрать заметку для просмотра
  - 2 = Кнопка "Выйти", возвращающая на экран "Архивы"*/

class ArchiveDetailsActivity (private val archive: Archive, private val menuManager: MenuManager) {
    fun start() {
        val options = archive.notes.map { it.title }.toMutableList().apply {
            add("Создать заметку")
            add("Выйти")
        }
        menuManager.showMenu(options)
        val input = menuManager.getUserInput()
        when (input) {
            in 1..archive.notes.size -> ViewNoteActivity(archive.notes[input - 1],archive, menuManager).start()
            archive.notes.size + 1 -> CreateNoteActivity(archive, menuManager).start()
            archive.notes.size + 2 -> ArchivesActivity(menuManager).start()
            else -> println("Повторите свой выбор.")
        }

    }

}
