import java.util.Scanner


var numberOfNotes: Int = 0
var listOfNotes: MutableList<String> = mutableListOf()


class Notes {

    fun createNewNote(): MutableList<String> {
        if (listOfNotes.size == 0) {
            numberOfNotes = listOfNotes.size
        }
        else numberOfNotes = listOfNotes.size
        println("NOTE MENU")
        println("To create a new note type the note name:")
        val inputNoteName = Scanner(System.`in`).nextLine()
        //проверяем, что не введена пустая строка или пробел
        if (inputNoteName.isNullOrEmpty() || inputNoteName.isBlank()) println("Invalid input")
        else {
            listOfNotes.add(inputNoteName)
            println("Note '${listOfNotes[numberOfNotes]}' created")
            numberOfNotes++

        }
        return listOfNotes
    }
}
