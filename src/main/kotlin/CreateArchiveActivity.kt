/*Основной функционал: Пользователь может ввести имя нового архива и создать его.
* Функции:
  - Форма для ввода названия архива
  - 0 = Кнопка "Сохранить архив", которая сохраняет архив в списке
  - 1 = Кнопка "Отмена", возвращающая на предыдущий экран без сохранения*/

class CreateArchiveActivity (private val archives: MutableList<Archive>, private val menuManager: MenuManager){
    fun start() {
        val options = mutableListOf("Сохранить", "Отмена")
        print("Введите название архива: ")
        val name = if (menuManager.scanner.hasNextLine()){
            menuManager.scanner.nextLine()
        }  else ""
        if (name.isEmpty()) {
            println("Имя архива не может быть пустым.")
            return
        }

        menuManager.showMenu(options)
        val input = menuManager.getUserInput()
        when (input) {
            1 -> saveArchive(name)
            2 -> cancel()
            else -> println("Выберите номер еще раз.")
        }

    }
    private fun saveArchive(name: String) {
        val newArchive = Archive(name)
        ArchiveManager.addArchive(newArchive)
        println("Архив '${newArchive.name}' создан.")
        ArchivesActivity(menuManager).start()
    }

    private fun cancel() {
        println("Архив не создан.")
        ArchivesActivity(menuManager).start()
    }
}


