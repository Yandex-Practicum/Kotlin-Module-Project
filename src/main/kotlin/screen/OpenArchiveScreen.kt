package screen

import data.Storage
import navigation.Navigator

class OpenArchiveScreen(private val archiveIndex: Int) : Screen() {

    override fun showMenu() {
        printInfo(
            "----------------\n" +
                    "Меню заметки - ${Storage.getArchives()[archiveIndex].name}\n" +
                    "----------------\n" +
                    "Выберете или создайте заметку:\n" +
                    "1. Создать заметку\n" +
                    "0. Назад\n" +
                    "---------------- \n"
        )

        if (Storage.getArchives()[archiveIndex].getNotes().isNotEmpty()) {
            printInfo("Или выберите из уже созданных:\n")
            Storage.getArchives()[archiveIndex].getNotes()
                .forEachIndexed { i, note -> println("${i + 2}. $note") }
        }
    }

    override fun nextStep() {
        while (true) {
            when (val step = Storage.sc.nextLine()) {
                "1" -> Navigator.push(CreateNoteScreen(archiveIndex))
                "0" -> Navigator.pop()
                else -> {
                    val index = step.toIntOrNull()

                    if (index != null && Storage.getArchives()[archiveIndex].existNote(index - 2)) {
                        Navigator.push(OpenNoteScreen(Storage.getArchives()[archiveIndex].getNote(index - 2)))
                    } else {
                        printError("Такого пункта меню нет\n")
                    }
                }
            }
        }
    }
}