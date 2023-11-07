/*Функции:
  - Просмотр содержимого заметки
  - Кнопка "Выйти", возвращающая на экран "Просмотр и управление архивом"*/
class ViewNoteActivity {
    val items: MutableList<Item> = mutableListOf(
        Item(0,"Выйти") { ArchiveDetailsActivity().start() }
    )
    private val menuManager = MenuManager(items)
    val notes: MutableList<Note> = mutableListOf()
    fun start() {
        while (true) {
            menuManager.showMenu()
            when(menuManager.getUserInput()) {
                0 -> items[0].inten
            }
        }
    }
}