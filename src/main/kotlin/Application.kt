import TypeMenu.*

class Application {
    val menuHandler = MenuHandler()
    var archives: HeadArchive = HeadArchive(mutableListOf())
    fun start(isOn: Boolean) {
        println("Привет! Это приложение «Заметки»")
        while (isOn) {
            getMenuAction(START_MENU, null)
        }
        println("Пока")
        return
    }

    fun getMenuAction(menuType: TypeMenu, archiveKey: Int?) {

        if (menuType == START_MENU) {
            menuType.getTextMenu()
            archives.showAllArchives()
        }
        var input = menuHandler.getUserInput()//menuHandler.getUserInputInt()
        if (menuType == START_MENU) { //Главное меню
            when (input) {
                "1" -> createArchive() //создание архива
                "2" -> {CHOOSER_MENU.getTextMenu()
                    var inputArch = menuHandler.getUserInputInt()
                    getMenuAction(ARCHIVES_MENU,inputArch)} //вход в меню внутрь архива
                "0" -> start(false)
                null -> getMenuAction(START_MENU,null)
                else -> {
                    println("Необходимо указать цифру из меню")
                    getMenuAction(START_MENU,null)
                }
            }
        }

        if (menuType == CHOOSER_MENU) { //Сообщение о вводе команды
            var inputArchiveKey = menuHandler.getUserInputInt()
            if (input != null) getMenuAction(ARCHIVES_MENU, inputArchiveKey)
        }

        if (menuType == ARCHIVES_MENU) {//МЕНЮ ВНУТРИ АРХИВА
            if (archiveKey != null ){
                println("Архив: ${archives.headArchive.get(archiveKey).name}")
            }
            ARCHIVES_MENU.getTextMenu()
            if (archiveKey != null) {
                archives.headArchive.get(archiveKey).showAllNotes()
            }
            input = menuHandler.getUserInput()
            when(input) {
                "1" -> { //Создание заметки
                    CREATE_NOTE_NAME_MENU.getTextMenu()
                    var nameNote = menuHandler.getUserInput()
                    if (menuHandler.isImputWrong(nameNote)) getMenuAction(ARCHIVES_MENU, archiveKey)
                    CREATE_NOTE_TEXT_MENU.getTextMenu()
                    var textNote = menuHandler.getUserInput()
                    if (menuHandler.isImputWrong(textNote)) getMenuAction(ARCHIVES_MENU, archiveKey)
                    if (archiveKey != null){
                        createNoteInArchive(archiveKey,nameNote,textNote)
                        getMenuAction(ARCHIVES_MENU, archiveKey)
                    }

                }
                "2" -> { //Просмотр заметки
                    CHOOSER_MENU.getTextMenu() //ожидание номера заметки
                    var inputIndexNote = menuHandler.getUserInputInt()
                    if (archiveKey != null && inputIndexNote != null ) archives.headArchive.get(archiveKey).notes.get(inputIndexNote).showNote()
                    NOTE_IS_SHOWN_MENU.getTextMenu() //Меню после показа заметки
                    when (menuHandler.getUserInputInt()) { //обработка
                        1 -> { //Добавить текст к заметке
                            var str = menuHandler.getUserInput()
                            if (archiveKey != null && inputIndexNote != null) archives.headArchive.get(
                                archiveKey).notes.get(inputIndexNote).addTextToNote(str)
                        }
                        0 -> getMenuAction(ARCHIVES_MENU, archiveKey) //Назад
                    }
                }
                "0" -> getMenuAction(START_MENU, null)
                else -> {println("Необходимо указать цифру из меню")
                getMenuAction(ARCHIVES_MENU,archiveKey)}
                }
        }
    }
    fun createArchive() { //Создание архива с именем
        CREATE_ARCHIVE_MENU.getTextMenu()
        var name = menuHandler.getUserInput()
        if (name.equals("00")) {
            getMenuAction(START_MENU, null)
        } else if (!menuHandler.isImputWrong(name)) {
        var archive = Archive(name, mutableListOf())
        archives.headArchive.add(archive)
            println("Архив $name создан")
        }
    }
    fun createNoteInArchive(key: Int, name: String, text: String) { //Создание заметки
var note = Note(name, text)
        archives.headArchive.get(key).notes.add(note)
        println("Заметка добавлена")
    }

}