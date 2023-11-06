import kotlin.system.exitProcess

class Archive(val id: Int, val name: String) {
}


class ArchiveAdd : ListInterface {
    override val title: String = "Добавляем архив"
    override val itemList: MutableList<MenuItem> = mutableListOf()

    init {
        itemList.add(MenuItem("Введите название архива"))
        itemList.add(MenuItem("", isActive = false, isExecute = true) {
            val name = scanner.nextLine()
            if (name.isEmpty()) {
                println("Название архива не должно быть пустым!")
                return@MenuItem

            }
            this.addArchive(name)
            println("Архив добавлен")

        })
        itemList.add(
            MenuItem(
                "Вернуться к списку архивов",
                isActive = true,
                isExecute = false
            ) { menu.showListMenu(ArchiveList()) })
    }

    private fun addArchive(name: String) {
        archivesData.add(Archive(archivesData.size, name))
    }
}

class ArchiveList : ListInterface {
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