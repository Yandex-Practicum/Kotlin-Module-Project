import java.util.*

class Menu {

    private fun <T : Storage> DisplayMenu (value: MutableList<T>, valueWord : List<String>) {
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
        }
        else {
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

    fun <T : Storage> inputUser (list: MutableList<T>, valueWord : List<String>) : Int {
        DisplayMenu(list, valueWord)
        while (true) {
            val userInput = Scanner(System.`in`).nextLine().toString()
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
                        DisplayMenu(list, valueWord)
                    }
                }
            } else {
                println("Введите правильное значение")
                DisplayMenu(list, valueWord)
            }
        }
    }
    fun addArchive () {
        println("Введите название создаваемого архива")
        val userInput = Scanner(System.`in`).nextLine().toString()
        arcives.add(Archive(userInput))
        println("Архив $userInput создан.")
    }
    fun addNote (id: String) {
        println("Введите название создаваемой заметки:")
        val nameofNote = Scanner(System.`in`).nextLine().toString()
        println("Введите содержание заметки:")
        val insideofNote = Scanner(System.`in`).nextLine().toString()
        note.add(Note(nameofNote, id, insideofNote))
        println("Заметка $nameofNote добавлена в архив $id")

    }
    fun editNote (note : Note) {
        print("${note.value} ")
        val addedText = Scanner(System.`in`).nextLine().toString()
        note.value = "${note.value} $addedText"

    }
}