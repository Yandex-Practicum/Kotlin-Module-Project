/*Функции:
  - поле для ввода заголовка заметки
  - поле для ввода текста заметки
  - 0 = Кнопка "Сохранить заметку", которая сохраняет заметку в текущем архиве
  - 1 = Кнопка "Отмена", возвращающая на предыдущий экран без сохранения заметки*/

class CreateNoteActivity (private val archive: Archive?, private val menuManager: MenuManager){

    fun start() {
        val options = mutableListOf("Сохранить заметку", "Отмена")
        print("Введите заголовок:")
        val title = if (menuManager.scanner.hasNextLine()){
            menuManager.scanner.nextLine()
        }  else ""
        if (title.isEmpty()) {
            println("Заголовок не может быть пустым.")
            return
        }

        print("Введите текст заметки:")
        val text = if (menuManager.scanner.hasNextLine()){
            menuManager.scanner.nextLine()
        } else ""
        if (text.isEmpty()) {
            println("Текст не может быть пустым.")
            return
        }

        menuManager.showMenu(options)
        val input = menuManager.getUserInput()
        when (input) {
            1 -> saveNote(title, text)
            2 -> cancel()
            else -> println("Выберите номер еще раз.")
        }
    }
    private fun saveNote(title:String, text: String) {
        val note = Note(title, text)
        archive?.addNote(note)
        println("Note '${note.title}' created.")
        if (archive != null) {
            ArchiveDetailsActivity(archive, menuManager).start()
        }
    }

    private fun cancel() {
        println("Заметка не создана.")
        if (archive != null) {
            ArchiveDetailsActivity(archive, menuManager).start()
        }
    }

}
