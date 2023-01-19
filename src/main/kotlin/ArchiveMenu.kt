import java.util.Scanner

object ArchiveMenu : Menu() {

    override var menuTitle: String = "\nВы в меню архивов:"
    override val menuItems: ArrayList<String> = arrayListOf(
        "Создать архив.",
        "Мой архив уже создан.",
        "Выход."
    )

    override var error: String = ""

    val archivesList: ArrayList<Archive> = arrayListOf<Archive>()

    fun printMenu() {
        while (true) {
            outputData(menuItems, -1, false, error)
            error = "Введите корректное значение между 0 и ${menuItems.size - 1}"
            var answer = inputData()
            if (answer.isValidInt()) {
                when (answer.toInt()) {
                    0 -> ArchiveCreating.printMenu()
                    1 -> ArchiveMenuVariants.printMenu()
                    2 -> return
                    else -> outputData(menuItems, -1, true, error)
                }
                continue
            } else {
                outputData(menuItems, -1, true, error)
            }
        }
    }

    fun createArchive(title: String) {
        archivesList.add(Archive(title))
    }

    fun createNote(index: Int, title: String, description: String) {
        archivesList[index].notesList.add(Notes(title, description))
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
                println("${menuItems.indexOf(menuItem)}. $menuItem")
            }
        } else {
            println(error)
        }
        println()
    }


}