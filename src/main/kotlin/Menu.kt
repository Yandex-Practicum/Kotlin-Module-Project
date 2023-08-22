import Creation.Companion.chooseArchive
import Creation.Companion.chooseNote
import Creation.Companion.createNote
import java.util.*

class Menu {
    companion object{

    }
    fun startMenuPrint() {
        while (true) {
            println(
                "Начало программы - \n" +
                        "0. Выбор архива\n" +
                        "1. Создать Архив\n" +
                        "2. Выход"
            )
            print("введите команду: ")
            val command = Input.scanner.nextLine()
            if (Input.checkInt(command)) {
                when (command) {
                    "0" -> chooseArchive()
                    "1" -> Archive.archives.add(Creation.createArchive())
                    "2" -> break
                    else -> println("такого пункта не существует, выберите существующий пункт")
                }
            }
        }
    }

    fun noteMenuPrint() {
        println(
            "0. Выбор заметки\n" +
                    "1. Создать заметку\n" +
                    "2. Назад"
        )
        print("введите команду: ")
        val command = Scanner(System.`in`).nextLine()
        if (Input.checkInt(command)) {
            when (command) {
                "0" -> chooseNote()
                "1" -> createNote()
                "2" -> startMenuPrint()

            }
        } else {
            noteMenuPrint()
        }
    }
}