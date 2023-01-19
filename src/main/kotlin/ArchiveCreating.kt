import java.util.Scanner

object ArchiveCreating : Menu() {

    override var menuTitle: String = "\nВы в меню создания архивов:"
    override val menuItems: ArrayList<String> = arrayListOf(
        "Введите название архива.",
        "Введите 0, чтобы выйти."
    )

    fun printMenu() {
        while (true) {
            outputData(menuItems, -1, false, error)
            val answer = inputData()
            when (answer) {
                "0" -> return
                else -> {
                    ArchiveMenu.createArchive(answer)
                    println("Архив '$answer' успешно добавлен.")
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