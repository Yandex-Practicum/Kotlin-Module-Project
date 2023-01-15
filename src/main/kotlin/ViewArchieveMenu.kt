import java.util.Scanner

object ViewArchieveMenu: Menu(), InterfaceIO {
    override var menuTitle: String = "\nВы в меню архива"
    override val menuItems: ArrayList<String> = arrayListOf(
        "Создать заметку",
        "Выйти"
    )
    override var error: String = ""

    fun printMenu(archiveIndex: Int) {
        while (true) {
            outputData(menuItems, archiveIndex, false, error)
            error = "Введите корректное значение - целое неотрицательное число между 0 и ${ArchivesMainMenu.archivesList[archiveIndex].notesList.size + 1}"
            var answer = inputData()
            if (answer.isValidInt()) {
                if (answer.toInt() in (0..(ArchivesMainMenu.archivesList[archiveIndex].notesList.size + 1))) {
                    when(answer.toInt()) {
                        ArchivesMainMenu.archivesList[archiveIndex].notesList.size -> {
                            CreateNoteMenu.printMenu(archiveIndex)
                            continue
                        }
                        ArchivesMainMenu.archivesList[archiveIndex].notesList.size + 1 -> {
                            return
                        }
                        else -> ViewNoteMenu.printMenu(archiveIndex, answer.toInt())
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
        if (!hasError) {
            println("$menuTitle '${ArchivesMainMenu.archivesList[elementIndex].title}'")
            if (ArchivesMainMenu.archivesList[elementIndex].notesList.size == 0) {
                println("У вас нет заметок, создайте их.\n${ArchivesMainMenu.archivesList[elementIndex].notesList.size}. ${menuItems[0]} \n${ArchivesMainMenu.archivesList[elementIndex].notesList.size+1}. ${menuItems[1]}\n")
            }
            else {
                for (note in ArchivesMainMenu.archivesList[elementIndex].notesList) {
                    println("${ArchivesMainMenu.archivesList[elementIndex].notesList.indexOf(note)}. ${note.title}")
                }
                println("${ArchivesMainMenu.archivesList[elementIndex].notesList.size}. ${menuItems[0]} \n${ArchivesMainMenu.archivesList[elementIndex].notesList.size+1}. ${menuItems[1]}\n")
            }
        }
        else {
            println(error)
        }
        println()

    }

}