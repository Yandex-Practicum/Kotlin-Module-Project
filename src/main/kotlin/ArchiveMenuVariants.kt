import java.util.Scanner

object ArchiveMenuVariants : Menu() {

    override var menuTitle: String = "\nВы в меню выбора архивов:"
    override val menuItems: ArrayList<String> = arrayListOf(
        "Введите 0, чтобы выйти."
    )
    override var error: String = ""

    fun printMenu() {
        while (true) {
            outputData(menuItems, -1, false, error)

            val answer = inputData()
            error =
                "Введите корректное значение - целое неотрицательное число от 0 до ${ArchiveMenu.archivesList.size}."
            if (answer.isValidInt()) {
                if (ArchiveMenu.archivesList.size == 0) {
                    if (answer.toInt() != 0) {
                        println(menuItems[0])
                    } else {
                        return
                    }
                } else {
                    if (answer.toInt() in 0..ArchiveMenu.archivesList.size) {
                        if (answer.toInt() == ArchiveMenu.archivesList.size) {
                            return
                        } else {
                            ViewArchive.printMenu(answer.toInt())
                            continue
                        }
                    } else {
                        outputData(menuItems, -1, true, error)
                    }
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
            if (ArchiveMenu.archivesList.size == 0) {
                println("Архивов не найдено, пожалуйста, создайте их. ${menuItems[0]}\n")
            } else {
                for (archive in ArchiveMenu.archivesList) {
                    println("${ArchiveMenu.archivesList.indexOf(archive)}. $archive")
                }
                println("${ArchiveMenu.archivesList.size}. Выход.\n")
            }
        } else {
            println(error)
        }
        println()
    }


}