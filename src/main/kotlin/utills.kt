import java.util.Scanner

val archiveList = mutableListOf<Archive>()
val scanner = Scanner(System.`in`)

fun createNewArchive() {
    println("Введите название архива")
    val newArchiveName = scanner.nextLine()
    archiveList.add(Archive(newArchiveName))
}

fun <T>mainFunction(
    title: String,
    firstItemText: String,
    list: MutableList<T>,
    currentArchive: Archive?,
    note: Note?,
) {
    if (note != null) {
        note.printFullNote()
        println("")
        println("Напишите 0 или 1, чтобы вернуться к списку заметок:")
    } else {
        println(title)
        println("0. Создать $firstItemText")

        list.forEachIndexed { i, item -> println("${i + 1} $item") }
        println("${list.size + 1} Выход")
        println("Выберите действие, введя номер пункта:")
    }
    var isInputOk = false

    while(!isInputOk) {
        val userInput: Int? = scanner.nextLine().toIntOrNull()
        if (userInput != null) {
            if (userInput <= list.size + 1) {
                isInputOk = when (userInput) {
                    0 -> {
                        if (note != null) {
                            true
                        } else {
                            inputCreate(title, firstItemText, list, currentArchive)
                        }
                    }
                    list.size + 1 -> true
                    else -> {
                        inputChooseItem(
                            "Список заметок:",
                            "заметку",
                            list,
                            userInput,
                            currentArchive
                        )
                    }
                }
            } else {
                println("Действия с таким номером не существует, введите число от 0 до ${list.size + 1}")
            }
        } else {
            println("Пожалуйста, введите число от 0 до ${list.size + 1}")
        }
    }
}

fun <T>inputCreate(
    title: String,
    firstItemText: String,
    list: MutableList<T>,
    currentArchive: Archive?
): Boolean {
    if (currentArchive != null) {
        currentArchive.addNote()
        PrintNoteListUtils(title, firstItemText, list, currentArchive)
    } else {
        createNewArchive()
        PrintArchiveListUtils(title, firstItemText, list)
    }
    return true
}

fun <T>inputChooseItem(
    title: String,
    firstItemText: String,
    list: MutableList<T>,
    userInput: Int,
    currentArchive: Archive?
): Boolean {
    if (currentArchive != null) {
        PrintNoteUtils(list[userInput - 1] as Note, mutableListOf<Note>())
        PrintNoteListUtils(title, firstItemText, list, currentArchive)
    } else {
        val currArchive: Archive = list[userInput - 1] as Archive
        PrintNoteListUtils(
            title,
            firstItemText,
            currArchive.returnNoteList(),
            currArchive
        )
        PrintArchiveListUtils("Список архивов:", "архив", list)
    }
    return true
}