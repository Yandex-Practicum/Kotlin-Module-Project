import kotlin.system.exitProcess

class MenuArchives(private val userArchive: MutableList<UserArchives>) : MenuCommon(TitleTypes.ARCHIVES, null) {
    private var currArchive = 0
    override fun goPrevious() {
        println("Завершение работы приложения")
        exitProcess(1)
    }

    override fun createElement() {
        //add new item to archive
        NoteTools.printCreateNewArchiveHead()

        print("Введите наименование архива: ")
        val newName = NoteTools.waitUserResponse(UserResponseType.TEXT, 0, 0)
        userArchive.add(UserArchives(newName, mutableListOf()))
        println("Создан новый архив: $newName")
    }

    override fun showAllElements() {
        NoteTools.printAllArchivesHead()

        if (userArchive.size > 0) {
            println("1. Выход")
            var cnt = 1
            for (i in userArchive) {
                println("${++cnt}. ${i.archiveName}")
            }
            selectElement()
        } else {
            println("Список архивов пуст!!!")
            onCreate()
        }
    }

    override fun selectElement() {
        println("Для открытия архива выберите соответствующий пункт или 1.Выход")
        var userSelected = 0
        while (true) {
            userSelected = NoteTools.waitUserResponse(UserResponseType.SELECTED_MENU, 1, userArchive.size + 1).toInt()
            if (userSelected > userArchive.size + 1) println("Введено значение отсутствующего архива")
            else break
        }
        if (userSelected > 1) {
            currArchive = userSelected - 2
            println("Открываю ${userArchive[currArchive].archiveName}")
            //переход к следующему окну - заметки
            goNext()
        }
    }

    override fun goNext() {
        MenuNotes(userArchive[currArchive].notesList, userArchive[currArchive].archiveName).onCreate()
    }
}
