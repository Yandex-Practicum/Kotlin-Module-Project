import java.util.Scanner

object ViewArchive : Menu(), Interface {

    override var menuTitle: String = "\nВы в меню архива"
    override val menuItems: ArrayList<String> = arrayListOf(
        "Создать заметку.",
        "Выйти."
    )
    override var error: String = ""

    fun printMenu(archiveIndex: Int) {
        while (true) {
            outputData(menuItems, archiveIndex, false, error)
            error = "Введите корректное значение между 0 и ${ArchiveMenu.archivesList[archiveIndex].notesList.size + 1}."
            var answer = inputData()
            if (answer.isValidInt()) {
                if (answer.toInt() in (0..(ArchiveMenu.archivesList[archiveIndex].notesList.size + 1))) {
                    when(answer.toInt()) {
                        ArchiveMenu.archivesList[archiveIndex].notesList.size -> {
                            CreateNotesMenu.printMenu(archiveIndex)
                            continue
                        }
                        ArchiveMenu.archivesList[archiveIndex].notesList.size + 1 -> {
                            return
                        }
                        else -> ViewNotes.printMenu(archiveIndex, answer.toInt())
                    }
                }
                else {
                    outputData(menuItems, archiveIndex, true, error)
                }
            }
            else {
                outputData(menuItems, archiveIndex, true, error)
            }
        }
    }


    override fun inputData(): String {
        val scanner = Scanner(System.`in`)
        return scanner.nextLine()
    }

    override fun outputData(menuItems: ArrayList<String>, elementIndex: Int, hasError: Boolean, error: String) {

        val stringForFun: String = "${ArchiveMenu.archivesList[elementIndex].notesList.size}. ${menuItems[0]} \n${ArchiveMenu.archivesList[elementIndex].notesList.size + 1}. ${menuItems[1]}\n"

        if (!hasError) {
            println("$menuTitle '${ArchiveMenu.archivesList[elementIndex].title}'")
            if (ArchiveMenu.archivesList[elementIndex].notesList.size == 0) {
                println("Заметок не найдено, пожалуйста, создайте их.\n${stringForFun}")
            } else {
                for (note in ArchiveMenu.archivesList[elementIndex].notesList) {
                    println("${ArchiveMenu.archivesList[elementIndex].notesList.indexOf(note)}. ${note.title}")
                }
                println(stringForFun)
            }
        }
        else {
                println(error)
        }
            println()
        }

}



