import kotlin.collections.ArrayList

class Start : PrintData() {
    private var listArchives: ArrayList<Archive> = createDefaultData()

    private fun showArchivesList() {
        val menu = Menu("Список архивов:", "архив", listArchives) //0. Создать
        menu.showMenu()
    }

    fun work() {
        showArchivesList()
        while (true) {
            val number = askAction()
            val num = number.toIntOrNull()
            if (num != null && num <= this.listArchives.size + 1) {
                if (num == this.listArchives.size + 1) {
                    printHeader("Работа с программой окончена.", true)
                    break
                }

                if (num == 0) {
                    if (this.createArchive())
                        printHeader("Новый архив создан.", false)
                    showArchivesList()
                } else {
                    this.listArchives.get(num - 1).showNotesList()
                    this.listArchives.get(num - 1).waitingAction()
                    printHeader("Работа с заметками окончена.", false)
                    showArchivesList()
                }
            } else {
                printHeader("Введено некорретное число: $number", false)
            }
        }
    }


    private fun createArchive(): Boolean {
        printHeader("Создание архива.", true)
        val nameArh = askActionWithExit("Введите наименование Архива")
        if (!nameArh.equals("q")) {
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