package screen

import data.Storage
import navigation.Navigator

class CreateNoteScreen(private val archiveIndex: Int) : Screen() {

    override fun showMenu() {
        printInfo("Введите название заметки или 0 для выхода\n")

    }

    override fun nextStep() {
        while (true) {
            val step = Storage.sc.nextLine()

            if (step.isNotEmpty() && step != "0") {
                printInfo("Введите текст заметки")
                while (true) {
                    val noteText = Storage.sc.nextLine()

                    if (noteText.isEmpty()) {
                        printError("Заметка не может быть пустой\n")
                    } else {
                        println(
                            "Заметка создана.\nНазвание: $step\nТекст: $noteText \n"
                        )

                        Storage.getArchive(archiveIndex).addNote(step, noteText)
                        Navigator.pop()
                    }
                }
            } else {
                if (step == "0") {
                    return Navigator.pop()
                } else {
                    printError("Название заметки обязательно для заполнения\n")
                }
            }
        }
    }
}