
import java.util.Scanner

class CreateAndChoice {
    val scanner = Scanner(System.`in`)
    val archivesList = mutableListOf<Archives>()
    fun createArchive() {
        println("Введите название архива")
        val nameA = scanner.nextLine()
        if (nameA.isEmpty()) {
            println("Нельзя создать архив без имени")
            createArchive()
        } else {
            archivesList.add(Archives(nameA, mutableListOf()))
            println("Архив \"$nameA\" добавлен")
        }
    }

    fun addNoteToArchive(numberA: Int) {
        println("Введите имя заметки")
        val name1 = scanner.nextLine()
        if (name1.isEmpty()) {
            println("Нельзя создать заметку с пустым именем,повторите ввод")
            addNoteToArchive(numberA)
        }
        while (true) {
            println("Введите текст заметки")
            val text = scanner.nextLine()
            if (text.isEmpty()) {
                println("Нельзя создать заметку без содержания,повторите ввод")
            } else {
                archivesList[numberA].notes.add(Note(name1, text))
                println("Заметка $name1 создана")
                break
            }
        }
    }

    fun back() {
        println("Введите любой символ для возврата назад")
        scanner.nextLine()
    }
}






