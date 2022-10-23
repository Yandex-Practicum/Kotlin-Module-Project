import java.util.Scanner

object NoteApp: NoteLifeCycle{
    private const val MAX_ELEMENTS_IN_LISTS = 999 // Максимальное количество заметок и архивов
    // Максимальна возможное числов символов в выборе пунктов меню(количество разрядов числа у MAX_ELEMENTS_IN_LISTS)
    private const val MAX_INPUT_MENU_ITEM_STRING_LENGTH = 3
    override var currentState = State.BEGIN
    private var userInput = ""
    private val listArchive = mutableListOf<MenuElements.Archive>()
    private val scanner = Scanner(System.`in`)
    private var selectedArchive = -1
    private var selectedNote = -1
    private var selectedItemMenu = -1

    override fun onBegin() {
        println("Добро пожаловать в приложение Заметки!\n1.Начать\n2.Выход")
        requestUserInput("Введите пункт меню -> ")
        if (checkUserInput(1..2)) {
            when (selectedItemMenu) {
                1 -> currentState = State.ARCHIVE_CHOOSE
                2 -> currentState = State.EXIT
            }
        }
    }

    override fun onArchiveCreate() {
        requestUserInput("Введите имя архива -> ")
        if (userInput.isEmpty()) {
            println("Имя архива не может быть пустым, повторите попытку.")
            return
        }
        listArchive.add(MenuElements.Archive(userInput, mutableListOf()))
        println("Архив успешно создан!")
        currentState = State.ARCHIVE_CHOOSE
    }

    override fun onArchiveChoose() {
        println("Список архивов:")
        println("0. Создать архив")
        listArchive.forEachIndexed { index, archive ->  println("${index + 1}. ${archive.name}") }
        val numOfArchives = listArchive.size
        println("${numOfArchives + 1}. Выход")
        requestUserInput("Введите пункт меню -> ")
        if (userInput == "0" && numOfArchives == MAX_ELEMENTS_IN_LISTS) {
            println("Больше нельзя создать архивов, максимальное количество $MAX_ELEMENTS_IN_LISTS")
            return
        }
        if (checkUserInput(0..numOfArchives + 1)) {
            when (selectedItemMenu) {
                0 -> currentState = State.ARCHIVE_CREATE
                in 1..numOfArchives -> {
                    selectedArchive = selectedItemMenu - 1
                    currentState = State.NOTE_CHOOSE
                }
                numOfArchives + 1 -> currentState = State.EXIT
            }
        }
    }

    override fun onNoteCreate() {
        requestUserInput("Введите имя заметки -> ")
        if (userInput.isEmpty()) {
            println("Имя заметки не может быть пустым, повторите попытку.")
            return
        }
        print("Введите текст заметки -> ")
        listArchive[selectedArchive].notes.add(MenuElements.Note(userInput, scanner.nextLine()))
        println("Заметка успешно создана!")
        currentState = State.NOTE_CHOOSE
    }

    override fun onNoteChoose() {
        println("Список заметок в архиве ${listArchive[selectedArchive].name}:")
        println("0. Создать заметку")
        listArchive[selectedArchive].notes.forEachIndexed { index, note ->  println("${index + 1}. ${note.name}") }
        val numOfNotes = listArchive[selectedArchive].notes.size
        println("${numOfNotes + 1}. Выход")
        requestUserInput("Введите пункт меню -> ")
        if (userInput == "0" && numOfNotes == MAX_ELEMENTS_IN_LISTS) {
            println("Больше нельзя создать заметок, максимальное количество $MAX_ELEMENTS_IN_LISTS")
            return
        }
        if (checkUserInput(0..numOfNotes + 1)) {
            when (selectedItemMenu) {
                0 -> currentState = State.NOTE_CREATE
                in 1..numOfNotes -> {
                    selectedNote = selectedItemMenu - 1
                    currentState = State.VIEW_NOTE
                }
                numOfNotes + 1 -> currentState = State.ARCHIVE_CHOOSE
            }
        }
    }

    override fun onViewNote() {
        println("Заметка - $selectedNote. ${listArchive[selectedArchive].notes[selectedNote]}")
        println("1 - Вернуться")
        requestUserInput("Введите 1 чтобы вернуться к списку заметок -> ")
        if (checkUserInput(1..1)) {
            currentState = State.NOTE_CHOOSE
        }
    }

    override fun onExit() {
        val size = listArchive.size
        for (i in 0 until size) {
            listArchive[i].notes.clear()
        }
        listArchive.clear()
        println("Приложение завершено.")
    }

    /**
     * Проверка пользовательского ввода выбора меню
     * @param range Диапозон существующих значений пунктов меню
     */
    private fun checkUserInput(range: IntRange):Boolean {
        for (char in userInput) {
            if (!char.isDigit()) {
                println("Ошибка!\nНеобходимо ввести цифру пункта меню, повторите попытку.")
                return false
            }
        }
        when {
            userInput.isEmpty() -> {
                println("Ошибка!\nВвод не может быть пустым.")
                return false
            }
            userInput.length > MAX_INPUT_MENU_ITEM_STRING_LENGTH -> {
                println("Ошибка!\nТакого пункта меню нет, введите корректный пункт меню.")
                return  false
            }
        }
        selectedItemMenu = userInput.toInt()
        if (selectedItemMenu !in range) {
            println("Ошибка!\nТакого пункта меню нет, введите корректный пункт меню.")
            return false
        }
        return true
    }

    /**
     * Запрос пользовательского ввода
     * @param requestingText текст запроса
     */
    private fun requestUserInput(requestingText: String) {
        print(requestingText)
        userInput = scanner.nextLine()
    }
}