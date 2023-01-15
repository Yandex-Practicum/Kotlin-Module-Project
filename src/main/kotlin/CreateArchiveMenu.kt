import java.util.Scanner

object CreateArchiveMenu: Menu(), InterfaceIO {
    override var menuTitle: String = "\nВы в режиме создания архивов:"
    override val menuItems: ArrayList<String> = arrayListOf(
        "Введите название архива, чтобы создать архив",
        "Введите 0, чтобы выйти из режима создания архивов"
    )

    fun printMenu() {
        while (true) {
            outputData(menuItems, -1, false, error)
            var answer = inputData()
            when(answer) {
                "0" -> return
                else -> {
                    ArchivesMainMenu.createArchive(answer)
                    println("Архив '$answer' успешно добавлен")
                }
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
        println(menuTitle)
        for (menuItem in menuItems) {
            println("${menuItem.toString()}")
        }
        println()
    }
}