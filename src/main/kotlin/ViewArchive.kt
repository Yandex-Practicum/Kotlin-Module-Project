import java.util.Scanner

object ViewArchive : Menu() {

    override var menuTitle: String = "\nВы в меню архива"
    override val menuItems: ArrayList<String> = arrayListOf(
        "Создать заметку.",
        "Выйти."
    )
    override var error: String = ""

    fun printMenu(archiveIndex: Int) {
        while (true) {
            val archiveSize: Int = ArchiveMenu.archivesList[archiveIndex].notesList.size
            outputData(menuItems, archiveIndex, false, error)
            error = "Введите корректное значение между 0 и ${archiveSize + 1}."
            val answer = inputData()
            if (answer.isValidInt()) {
                if (answer.toInt() in (0..(archiveSize + 1))) {
                    when (answer.toInt()) {
                        archiveSize -> {
                            CreateNotesMenu.printMenu(archiveIndex)
                            continue
                        }
                        archiveSize + 1 -> {
                            return
                        }
                        else -> ViewNotes.printMenu(archiveIndex, answer.toInt())
                    }
                } else {
                    outputData(menuItems, archiveIndex, true, error)
                }
            } else {
                outputData(menuItems, archiveIndex, true, error)
            }
        }
    }

    override fun inputData(): String {
        val scanner = Scanner(System.`in`)
        return scanner.nextLine()
    }

    override fun outputData(
        menuItems: ArrayList<String>,
        elementIndex: Int,
        hasError: Boolean,
        error: String
    ) {
        val elementIndexSize: Int = ArchiveMenu.archivesList[elementIndex].notesList.size
        val stringForFun: String =
            "${elementIndexSize}. ${menuItems[0]} \n${elementIndexSize + 1}. ${menuItems[1]}\n"

        if (!hasError) {
            println("$menuTitle '${ArchiveMenu.archivesList[elementIndex].title}'")
            if (elementIndexSize == 0) {
                println("Заметок не найдено, пожалуйста, создайте их.\n${stringForFun}")
            } else {
                for (note in ArchiveMenu.archivesList[elementIndex].notesList) {
                    println("${ArchiveMenu.archivesList[elementIndex].notesList.indexOf(note)}. ${note.title}")
                }
                println(stringForFun)
            }
        } else {
            println(error)
        }
        println()
    }

}



