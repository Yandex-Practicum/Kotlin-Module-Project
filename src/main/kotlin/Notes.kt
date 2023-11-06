class Notes(val id: Int, val name: String, val text: String, val archiveId: Int) {

}

class NotesDetail(val noteId: Int) : ListInterface {
    override var title: String = ""
    override val itemList: MutableList<MenuItem> = mutableListOf()

    init {
        val tempNote: Notes = notesData.filter { i -> i.id == noteId }[0]
        title = "Просмотр заметки ${tempNote.name}"
        itemList.add(MenuItem(tempNote.text, isActive = false, isExecute = false) { })

        itemList.add(MenuItem(
            "Назад к списку заметок", isActive = true, isExecute = false
        ) { menu.showListMenu(NotesList(tempNote.archiveId)) })
    }
}

class NotesList(private val archiveId: Int) : ListInterface {

    override val title = "Список заметок"
    override val itemList: MutableList<MenuItem> = mutableListOf()

    init {

        itemList.add(MenuItem(
            "Создать заметку", isActive = true, isExecute = false
        ) { menu.showListMenu(NotesAdd(archiveId)) })
        for (i in notesData.filter { i -> i.archiveId == archiveId }) {
            itemList.add(MenuItem(i.name, isActive = true, isExecute = false) {
                menu.showListMenu(
                    NotesDetail(i.id)
                )
            })
        }
        itemList.add(
            MenuItem(
                "Назад к списку архивов", isActive = true, isExecute = false
            ) { menu.showListMenu(ArchiveList()) })
    }
}

class NotesAdd(archiveId: Int) : ListInterface {
    override val title: String = "Добавление заметки"
    override val itemList: MutableList<MenuItem> = mutableListOf()

    init {
        itemList.add(MenuItem("Введите название Заметки"))
        itemList.add(MenuItem("", isActive = false, isExecute = true) {
            val name = scanner.nextLine()

            if (name.isEmpty()) {
                println("Название заметки не должно быть пустым!")
                return@MenuItem

            }
            println("Введите текст заметки")


            val text = scanner.nextLine()
            if (text.isEmpty()) {
                println("Текст заметки не должен быть пустым!")
                return@MenuItem

            }
            this.addNote(name, text, archiveId)
            println("Заметка успешно добавлена")

        })

        itemList.add(MenuItem(
            "Вернуться к списку заметок", isActive = true, isExecute = false
        ) { menu.showListMenu(NotesList(archiveId)) })
    }

    fun addNote(name: String, text: String, archiveId: Int) {
        notesData.add(Notes(notesData.size, name, text, archiveId))
    }

}

