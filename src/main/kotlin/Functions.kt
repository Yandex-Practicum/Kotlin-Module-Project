import java.util.Scanner

class Functions(val choiceSelection: Choice) {

    var scanner = Scanner(System.`in`)
    val archiveList = mutableListOf<Archive>()
    var currentArchiveIndex: Int = -1

    fun userInput(): String {
        return scanner.nextLine()
    }

    fun promptInput(prompt: String): String {
        while (true) {
            println(prompt)
            val input = userInput()
            if (input.isNotBlank()) {
                return input
            } else {
                println("Некорректный ввод, попробуйте снова.")
            }
        }
    }

    fun menuOptions(options: List<String>): Int {
        options.forEachIndexed { index, option -> println("$index. $option") }
        while (true) {
            val input = userInput().toIntOrNull()
            if (input != null && input in options.indices) {
                return input
            } else {
                println("Введите корректный номер.")
            }
        }
    }

    fun createArchive() {
        val nameOfArchive = promptInput("Введите название архива: ")
        val newArchive = Archive(name = nameOfArchive, notes = mutableListOf())
        archiveList.add(newArchive)
        println("Архив создан: ${newArchive.name}")
        choiceSelection.action(State.ARCHIVE_CHOOSE)
    }

    fun chooseArchive() {
        println("Список архивов:")
        val options = listOf("Создать архив") + archiveList.map { it.name } + "Выход"
        when (val choice = menuOptions(options)) {
            0 -> choiceSelection.action(State.ARCHIVE_CREATE)
            in 1..archiveList.size -> {
                currentArchiveIndex = choice - 1
                val chosenArchive = archiveList[currentArchiveIndex]
                println("Открыт архив: ${chosenArchive.name}")
                choiceSelection.action(State.ARCHIVE_OPEN)
            }
            archiveList.size + 1 -> choiceSelection.exit()
        }
    }

    fun openArchive() {
        if (currentArchiveIndex == -1 || currentArchiveIndex >= archiveList.size) {
            println("Ошибка при выборе архива.")
            choiceSelection.action(State.ARCHIVE_CHOOSE)
            return
        }
        val currentArchive = archiveList[currentArchiveIndex]
        println("Список заметок архива '${currentArchive.name}':")
        val options = listOf("Создать заметку") + currentArchive.notes.map { it.tittle } + "Выход"
        when (val choice = menuOptions(options)) {
            0 -> choiceSelection.action(State.NOTES_CREATE)
            in 1..currentArchive.notes.size -> {
                val chosenNote = currentArchive.notes[choice - 1]
                println("Открыта заметка: ${chosenNote.tittle}")
                println("Содержание: ${chosenNote.content}")
                choiceSelection.action(State.NOTES_OPEN)
            }
            currentArchive.notes.size + 1 -> choiceSelection.action(State.ARCHIVE_CHOOSE)
        }
    }

    fun openNotes() {
        openArchive()
    }

    fun createNotes() {
        if (currentArchiveIndex == -1 || currentArchiveIndex >= archiveList.size) {
            println("Ошибка при выборе архива.")
            choiceSelection.action(State.ARCHIVE_CHOOSE)
            return
        }
        val currentArchive = archiveList[currentArchiveIndex]
        val title = promptInput("Введите заголовок заметки: ")
        val content = promptInput("Введите содержание заметки: ")

        val newNote = Note(tittle = title, content = content)
        currentArchive.notes.add(newNote)
        println("Заметка создана: ${newNote.tittle}")
        choiceSelection.action(State.ARCHIVE_OPEN)
    }
}
