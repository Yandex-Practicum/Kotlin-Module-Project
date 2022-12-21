import java.util.*

class Menu {


    private fun <T : Storage> displayMenu(value: MutableList<T>, valueWord: List<String>) {

        if (valueWord[0] != "заметке") {
            println("Список ${valueWord[0]}:")
            if (value.size >= 1) {
                for (i in value.indices) {
                    if (i == 0) {
                        println("$i. Создать ${valueWord[1]}")
                    }
                    println("${i + 1}. ${value[i].name}")
                    if (i == value.lastIndex) {
                        println("${i + 2}. Выход")
                    }
                }
            } else {
                println("0. Создать ${valueWord[1]}")
                println("1. Выход")
            }
        } else {
            println("0. Показать заметку")
            println("1. Добавить текст к ${valueWord[0]}")
            println("2. Выход")
        }
    }

    private fun isNumbers(input: String): Boolean {
        val integerChars = '0'..'9'
        var dotOccurred = 0
        return input.all { it in integerChars || it == '.' && dotOccurred++ < 1 }
    }

    fun <T : Storage> inputUser(list: MutableList<T>, valueWord: List<String>): Int {
        displayMenu(list, valueWord)
        while (true) {
            val userInput = Scanner(System.`in`).nextLine()
            if (isNumbers(userInput)) {
                if (valueWord[0] == "заметке") {
                    if (userInput.toInt() <= 2) {
                        return userInput.toInt()
                    }
                }
                when (userInput.toInt()) {
                    in 0..list.size + 1 -> return userInput.toInt()
                    else -> {
                        println("В меню нет пункта $userInput.")
                        displayMenu(list, valueWord)
                    }
                }
            } else {
                println("Несуществующий пункт меню, введите правильное значение")
                displayMenu(list, valueWord)
            }
        }
    }

    fun addArchive() {
        println("Введите название архива")
        val userInput = Scanner(System.`in`).nextLine()
        archives.add(Archive(userInput))
        println("Архив $userInput создан.")
    }

    fun addNote(id: String) {
        println("Введите название заметки:")
        val nameNote = Scanner(System.`in`).nextLine()
        println("Введите текс заметки:")
        val textNote = Scanner(System.`in`).nextLine()
        note.add(Note(nameNote, id, textNote))
        println("Заметка $nameNote добавлена в архив $id")

    }

    fun editNote(note: Note) {
        print("${note.value} ")
        val addedText = Scanner(System.`in`).nextLine()
        note.value = "${note.value} $addedText"

    }
}