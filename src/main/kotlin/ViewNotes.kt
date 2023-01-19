import java.util.Scanner

object ViewNotes : Menu() {

    override var menuTitle: String = "\nВы в меню просмотра заметки:"
    override val menuItems: ArrayList<String> = arrayListOf(
        "Введите 0, чтобы выйти."
    )

    override var error: String = menuItems[0]

    fun printMenu(archieveIndex: Int, noteIndex: Int) {
        while (true) {
            outputData(menuItems, -1, false, error)
            println(ArchiveMenu.archivesList[archieveIndex].notesList[noteIndex].toString())
            error = "Пожалуйста, введите число 0, чтобы выйти из режима просмотра заметки."
            val answer = inputData()

            if (answer.isValidInt()) {
                if (answer.toInt() == 0) {
                    return
                }
            } else {
                outputData(menuItems, -1, true, error)
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
        if (!hasError) {
            println(menuTitle)
            for (menuItem in menuItems) {
                println(menuItem)
            }
        } else {
            println(error)
        }
        println()
    }


}