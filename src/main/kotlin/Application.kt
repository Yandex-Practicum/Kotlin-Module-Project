import TypeMenu.*
import kotlin.system.exitProcess

class Application {
    private val menuHandler = MenuHandler()
    private var archives: HeadArchive = HeadArchive(mutableListOf())
    fun start(isOn: Boolean) {
        while (isOn) {
            getMenuActionByTypeMenu(START_MENU, null, null)
        }
        println("Пока")

        exitProcess(0)
    }


    private fun getMenuActionByTypeMenu(menu: TypeMenu, archiveKey: Int?, noteKey: Int?) {
        if (menu == START_MENU) {
            showStartMenuText()
        } else if (menu == ARCHIVES_MENU) {
            showArchivesMenuText(archiveKey)
        }

        when (menuHandler.getUserInput()) {
            "1" -> if (menu == START_MENU) {
                createArchive()
            } else if (menu == ARCHIVES_MENU) {
                createNote(archiveKey)
            } else if (menu == NOTE_IS_SHOWN_MENU) {
                addTextToNote(archiveKey, noteKey)
            }

            "2" -> if (menu == START_MENU) {
                getInArchiveMenu()
            } else if (menu == ARCHIVES_MENU) {
                showNoteOfArchive(archiveKey)
            }

            "0" -> if (menu == START_MENU) {
                start(false)
            } else if (menu == ARCHIVES_MENU) {
                getMenuActionByTypeMenu(START_MENU, null, null)
            } else if (menu == NOTE_IS_SHOWN_MENU) {
                getMenuActionByTypeMenu(ARCHIVES_MENU, archiveKey, null)
            }

            else -> showErrorInputMessage()

        }
    }

    private fun showStartMenuText() { //показ начального меню и наличия архивов
        START_MENU.getTextMenu()
        println("Список архивов")
        showContent(archives.headArchive)
    }


    private fun showErrorInputMessage() {
        println("Необходимо указать цифру из меню")
        getMenuActionByTypeMenu(START_MENU, null, null)
    }

    private fun showArchivesMenuText(archiveKey: Int?) { //показ меню определённого архива и наличия заметок
        if (archiveKey != null) {
            println("Вы в Архиве: ${archives.headArchive[archiveKey].name}")
        }
        ARCHIVES_MENU.getTextMenu()
        if (archiveKey != null) {
            showContent(archives.headArchive[archiveKey].notes)
        }
    }

    private fun createNote(archiveKey: Int?) { //создание заметки перед добавлением в архив
        CREATE_NOTE_NAME_MENU.getTextMenu()
        val nameNote = menuHandler.getUserInput()
        if (menuHandler.isInputWrong(nameNote)) getMenuActionByTypeMenu(
            ARCHIVES_MENU,
            archiveKey,
            null
        )
        CREATE_NOTE_TEXT_MENU.getTextMenu()
        val textNote = menuHandler.getUserInput()
        if (menuHandler.isInputWrong(textNote)) getMenuActionByTypeMenu(
            ARCHIVES_MENU,
            archiveKey,
            null
        )
        if (archiveKey != null) {
            createNoteInArchive(archiveKey, nameNote, textNote) //добавление заметки в архив
            getMenuActionByTypeMenu(ARCHIVES_MENU, archiveKey, null)
        }
    }

    private fun addTextToNote(
        archiveKey: Int?,
        noteKey: Int?,
    ) { //добавление текста в существующую заметку
        println("Введи текст")
        val string = menuHandler.getUserInput()
        if (archiveKey != null && noteKey != null) {
            val noteToUpdate = archives.headArchive[archiveKey].notes[noteKey]
            noteToUpdate.text += string
            archives.headArchive[archiveKey].notes[noteKey] = noteToUpdate
        }
        println("Текст изменён")
        if (archiveKey != null && noteKey != null) {
            archives.headArchive[archiveKey].notes[noteKey].showNote()
            getMenuActionByTypeMenu(ARCHIVES_MENU, archiveKey, null)
        }
    }

    private fun getInArchiveMenu() { //вход в архив
        CHOOSER_MENU.getTextMenu()
        val inputArchive = menuHandler.getUserInputInt()//выбор архива по номеру
        getMenuActionByTypeMenu(ARCHIVES_MENU, inputArchive, null)
    }

    private fun showNoteOfArchive(archiveKey: Int?) { //показ заметки архива
        CHOOSER_MENU.getTextMenu() //ожидание ввода номера заметки из архива
        val inputIndexNote = menuHandler.getUserInputInt()
        if (archiveKey != null && inputIndexNote != null) {
            archives.headArchive[archiveKey].notes[inputIndexNote].showNote()
        }
        NOTE_IS_SHOWN_MENU.getTextMenu() //Меню после показа заметки
        getMenuActionByTypeMenu(NOTE_IS_SHOWN_MENU, archiveKey, inputIndexNote)
    }

    private fun <T> showContent(list: List<T>) {
        if (list.isEmpty()) {
            println("Список пуст")
        }
        list.forEachIndexed { i, t ->
            if (t is Archive) {
                println("* * *\n$i. ${t.name}\n")
            } else if (t is Note) {
                println("~ ~ ~\n$i. ${t.name}\n")
            }
        }
    }

    private fun createArchive() { //Создание архива с именем
        CREATE_ARCHIVE_MENU.getTextMenu()
        val name = menuHandler.getUserInput()
        if (name == "0") {
            getMenuActionByTypeMenu(START_MENU, null, null)
        } else if (!menuHandler.isInputWrong(name)) {
            var archive = Archive(name, mutableListOf()) //изменяемый архив для обновления заметок
            archives.headArchive.add(archive)
            println("Архив $name создан")
        }
    }

    private fun createNoteInArchive(
        key: Int,
        nameNote: String,
        textNote: String,
    ) { //Создание заметки
        val newNote = Note(nameNote, textNote)
        archives.headArchive[key].notes.add(newNote)
        println("Заметка добавлена")
    }

}