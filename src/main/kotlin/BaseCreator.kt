import Item.Archive
import Item.Note

class BaseCreator {
    fun createArchive(): Archive {
        println("Введите название архива больше 3-х символов:")
        var name = inputString()
        return Archive(name.toString(), mutableListOf<Note>())
    }

    fun createNote(): Note {
        println("Введите название заметки:")
        var name = inputString()
        println("Введите текст заметки:")
        var text = inputString()
        return Note(name,text)
    }

    fun inputString(): String {
        var input = readlnOrNull() ?: ""
         while (input.length < 3) {
             println("Введите больше 3-х символов:")
             input = readlnOrNull() ?: ""
         }
        return input
    }
}