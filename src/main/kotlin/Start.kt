import kotlin.collections.ArrayList

class Start : PrintData(), ActWhile {
    private var listArchives: ArrayList<Archive> = createDefaultData()

    private fun showArchivesList() {
        val menu = Menu("Список архивов:", "архив", listArchives) //0. Создать
        menu.showMenu()
    }

    fun work() {
        showArchivesList()
        userResultAction(listArchives)
    }

    //region override fun
    override fun finishAction() {
        printHeader("Работа с программой окончена.", true)
    }

    override fun createAction() {
        if (createArchive())
            printHeader("Новый архив создан.", false)
        showArchivesList()
    }

    override fun showAction(num: Int) {
        listArchives[num - 1].showNotesList()
        listArchives[num - 1].waitingAction()
        printHeader("Работа с заметками окончена.", false)
        showArchivesList()
    }

    override fun wrongNumberAction(number: String) {
        //printHeader("Введено некорретное число: $number", false)
        printError(number)
    }
    //endregion

    private fun createArchive(): Boolean {
        printHeader("Создание архива.", true)
        val nameArh = askActionWithExit("Введите наименование Архива")
        if (nameArh != "q") {
            val listNotes: ArrayList<Note> = arrayListOf()
            return listArchives.add(Archive(nameArh, listNotes))
        } else
            cancelCreateArchive()

        return false
    }

    private fun cancelCreateArchive() {
        printHeader("Создание архива отменено", false)
    }

    //--------------------------------------------------//
    //region данные в программе (по умолчанию)
    private fun createDefaultData(): ArrayList<Archive> {
        val listNotes: ArrayList<Note> = arrayListOf()
        val listArchives: ArrayList<Archive> = arrayListOf()
        listArchives.add(Archive("Это мой уже созданный архив", listNotes))
        listNotes.add(
            Note(
                "Это моя уже созданная заметка",
                "Это содержимое уже созданной заметки", listArchives[0]
            )
        )

        return listArchives
    }
    //endregion
}