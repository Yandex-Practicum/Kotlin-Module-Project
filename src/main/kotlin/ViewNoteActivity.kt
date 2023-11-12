/*Функции:
  - Просмотр содержимого заметки
  - Кнопка "Выйти", возвращающая на экран "Просмотр и управление архивом"*/
class ViewNoteActivity (private val note: Note, private val archive: Archive, private val menuManager: MenuManager){
    fun start() {
        val options = mutableListOf("Выйти")
        println("Заметка: ${note.title}\n${note.text}")

        menuManager.showMenu(options)
        val input = menuManager.getUserInput()
        when (input) {
            1 -> ArchiveDetailsActivity(archive, menuManager).start()
            else -> println("Выберите номер еще раз.")
        }
    }
}