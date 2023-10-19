import kotlin.system.exitProcess

class Archive(val id: Int, val name: String) {
}

class ArchiveAdd() : ListInterface {  // Добавляем архив
    override val title: String = "Добавляем архив"
    override val itemList: MutableList<MenuItem> = mutableListOf()

    init {
        itemList.add(MenuItem("Введите название архива")) // Название архива
        itemList.add(MenuItem("", isActive = false, isExecute = true) {
            val name = scanner.nextLine()
            this.addArchive(name)
            println("Архив добавлен")  // Добавили архив (показать процесс)
        })
        itemList.add(
            MenuItem(
                "Вернуться к списку архивов", //Вернуться назад к списку
                isActive = true,
                isExecute = false
            ) { menu.showListMenu(ArchiveList()) })
    }

    fun addArchive(name: String) {
        archivesData.add(Archive(archivesData.size, name))
    }
}

class ArchiveList() : ListInterface {  // Создаем список архивов
    override val title = "Список архивов"
    override val itemList: MutableList<MenuItem> = mutableListOf()

    init {

        itemList.add(
            MenuItem(
                "Создать архив",
                isActive = true,
                isExecute = false
            ) { menu.showListMenu(ArchiveAdd()) })
        for (i in archivesData) {
            itemList.add(MenuItem(i.name, isActive = true, isExecute = false) {
                menu.showListMenu(
                    NotesList(i.id)
                )
            })
        }
        itemList.add(MenuItem("Выход", isActive = true, isExecute = false) { exitProcess(0) })
    }
}