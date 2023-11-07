/*Функции:
  - поле для ввода заголовка заметки
  - поле для ввода текста заметки
  - 0 = Кнопка "Сохранить заметку", которая сохраняет заметку в текущем архиве
  - 1 = Кнопка "Отмена", возвращающая на предыдущий экран без сохранения заметки*/

class CreateNoteActivity {
    private val items: MutableList<Item> = mutableListOf(
        Item(0,"Сохранить заметку") { CreateArchiveActivity().start() },
        Item(1,"Отмена") { ArchiveDetailsActivity().start() }
    )
    private val menuManager = MenuManager(items)

    fun start() {
        while (true) {
            menuManager.showMenu()
            when(menuManager.getUserInput()) {
                0 -> items[0].inten
                1 -> items[1].inten
            }
        }
    }

}
