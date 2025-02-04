package screen

import models.Note
import data.Storage
import navigation.Navigator

class OpenNoteScreen(private val note: Note) : Screen() {

    override fun showMenu() {
        printInfo(
            "---------------\n" +
                    "Название заметки: ${note.name} \n" +
                    "Текст заметки: ${note.text} \n" +
                    "Введите любой текст для выхода\n" +
                    "---------------\n"
        )

    }

    override fun nextStep() {
        Storage.sc.nextLine()
        Navigator.pop()
    }
}