import java.util.Scanner

class Screen(val navigationListener: NavigationListener) {
    val list: MutableList<Archive> = mutableListOf()
    private var currentArchive : Int = 0
    private var currentNote: Int = 0

    fun chooseArchiveScreen() {
        println("0. Создать Архив")
        list.forEachIndexed { index, archive -> println("${index + 1}. ${archive.name}") }
        println("${list.size + 1}. Выход.")
        val choice = checkInput(list.size + 1)
        while (choice == - 1) {
            chooseArchiveScreen()
        }
        when (choice) {
            0 -> navigationListener.state(State.ADD_ARCHIVE)
            in 1.. list.size -> {
                currentArchive = choice
                navigationListener.state(State.OPEN_ARCHIVE)
            }
            else -> navigationListener.exit()
        }
    }

    fun addNewArchive() {
        println("Введите название для нового Архива:")
        val archiveName = Scanner(System.`in`).nextLine()
        list.add(Archive(archiveName))
        navigationListener.state(State.CHOOSE_ARCHIVE)
    }

    fun openArchive() {
        println("0. Создать Заметку")
        list[currentArchive - 1].list.forEachIndexed { index, note -> println("${index + 1}. ${note.noteName}") }
        println("${list[currentArchive - 1].list.size + 1}. Выход.")
        val listLength = list[currentArchive - 1].list.size
        val choice = checkInput(listLength + 1)
        while (choice == - 1) {
           openArchive()
        }
        when (choice) {
            0 -> navigationListener.state(State.ADD_NOTE)
            list[currentArchive - 1].list.size + 1 -> { navigationListener.state(State.CHOOSE_ARCHIVE)}
            in 1.. list.size -> {
              currentNote = choice
                navigationListener.state(State.OPEN_NOTE)
            }
            else -> navigationListener.state(State.CHOOSE_ARCHIVE)
        }
    }

    fun makeNote() {

        println("Введите название заметки:")
        val noteTitle = Scanner(System.`in`).nextLine()
        println("Введите текст:")
        val noteText = Scanner(System.`in`).nextLine()
        list[currentArchive - 1].list.add(Note(noteTitle, noteText))
        navigationListener.state(State.OPEN_ARCHIVE)
    }

    fun openNote() {
        val noteName = list[currentArchive - 1].list[currentNote - 1].noteName
        val noteText = list[currentArchive - 1].list[currentNote - 1].noteText
        println("Название: $noteName")
        println("Текст: $noteText")

        do {
            println("Нажмите 1 для выхода.")
            val pressExit = Scanner(System.`in`).nextLine()
        } while (pressExit != "1")
        navigationListener.state(State.OPEN_ARCHIVE)
    }

    fun checkInput(length: Int) : Int {
        val choice = Scanner(System.`in`).nextLine()

        if (choice.toIntOrNull() == null) {
            println("Вы ввели неправильное значение. Попробуйте еще раз.")
            return -1
        }
        if (choice.isNullOrEmpty()) {
            println("Неправильное значение. Введите цифру еще раз.")
            return - 1
        }
        if (choice.toInt() > length) {
            println("Введите корректное значение.")
            return - 1
        }
        return choice.toInt()
    }


}


