/*Функции:
  - Просмотр содержимого выбранного из списка  ArchivesActivity архива
  - 0 = Кнопка "Создать заметку" в архиве
  - 1 = Возможность выбрать заметку для просмотра
  - 2 = Кнопка "Выйти", возвращающая на экран "Архивы"*/

class ArchiveDetailsActivity {
    val items: MutableList<Item> = mutableListOf(
        Item(0,"Создать заметку") { CreateNoteActivity().start() },
        Item(1,"Выбрать заметку") { ViewNoteActivity().start() },
        Item(2,"Выйти") { ArchivesActivity().start() }
    )
    private val menuManager = MenuManager(items)
    val notes: MutableList<Note> = mutableListOf()
    fun start() {
        while (true) {
            menuManager.showMenu()
            when(menuManager.getUserInput()) {
                0 -> items[0].inten
                1 -> items[1].inten
                2 -> break
            }
        }
    }

}
