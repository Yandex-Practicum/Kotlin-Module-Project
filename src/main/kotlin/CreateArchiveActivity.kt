/*Основной функционал: Пользователь может ввести имя нового архива и создать его.
* Функции:
  - Форма для ввода названия архива
  - 0 = Кнопка "Сохранить архив", которая сохраняет архив в списке
  - 1 = Кнопка "Отмена", возвращающая на предыдущий экран без сохранения*/

class CreateArchiveActivity {
    val items: MutableList<Item> = mutableListOf(
        Item(0,"Сохранить архив") { addArchive() },
        Item(1,"Отмена") { ArchivesActivity().start() }
    )
    private var title:String = ""
    private val menuManager = MenuManager(items)
    fun start() {
        println("Введите название архива")
        var title: String = menuManager.userInputValidationText()
        
        while (true) {
            menuManager.showMenu()
            when(menuManager.getUserInput()) {
                0 -> items[0].inten
                1 -> items[1].inten
            }
        }
    }

    private fun addArchive() {

        ArchivesActivity().archives.add(Archive(listOf(), title))
        println("Архив $title сохранен")
        ArchivesActivity().start()
    }

}