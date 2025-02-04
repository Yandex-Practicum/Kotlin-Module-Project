package screen

import data.Storage
import navigation.Navigator

class ArchiveScreen : Screen() {

    override fun showMenu() {
        printInfo(
            "Программа по созданию заметок: \n" +
                    "1. Создать Архив\n" +
                    "0. Выход\n" +
                    "----------------\n"
        )
        if (Storage.getArchives().isNotEmpty()) {
            printInfo("Или выберите из уже созданных:\n")
            Storage.getArchives().forEachIndexed() { i, archive -> println("${i + 2}. $archive") }
        }
    }

    override fun nextStep() {
        while (true) {
            when (val step = Storage.sc.nextLine()) {
                "1" -> {
                    Navigator.push(CreateArchiveScreen())
                }

                "0" -> {
                    Navigator.pop()
                }

                else -> {
                    val index = step.toIntOrNull()

                    if (index != null && Storage.existArchive(index - 2)) {
                        Navigator.push(OpenArchiveScreen(index - 2))
                    } else {
                        printError("Такого пункта меню нет \n")
                    }
                }
            }
        }
    }


}