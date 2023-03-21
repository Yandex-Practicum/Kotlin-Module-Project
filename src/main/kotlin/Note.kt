import java.util.*

class Note(override var name :String, var noteText : String = "" ) : Checkable {

    private val scanner = Scanner(System.`in`)
    companion object {

        fun createNote(archive: Archive, archiveCommands : List<String>){
            val scanner = Scanner(System.`in`)
            while (true){
                println("Введите название заметки")
                val userNameNote = scanner.nextLine()
                if(userNameNote == ProgramManager.EXIT_ARCHIVE || userNameNote == ProgramManager.CREATE_NOTE){
                    println("Название не может быть командой")
                    continue
                }
                else if(archiveCommands.contains(userNameNote)){
                    println("Архив с таким название уже есть")
                    continue
                }

                println("Введите текст заметки")
                val noteText = scanner.nextLine()

                val note = Note(userNameNote, noteText)
                archive.addNoteToList(note)
                break
            }
        }
    }

    fun openNote(){
        while (true){
            println("Название: ${this.name}")
            println("Текст: ${this.noteText}")
            println("0. Редактировать заметку")
            println("1. Выйти из заметки")

            val input = scanner.nextLine()

            if(input.toIntOrNull() === null){
                println("Необходимо ввести число!")
                continue
            }

            val num = input.toInt()

            if(num != 1 && num != 0){
                println("Такой команды нет!")
                continue
            }

            when(num){
                1 -> break
                0 -> {
                    println("Введите новый текст для заметки")
                    val newText = scanner.nextLine()
                    this.noteText = newText
                    continue
                }
            }

        }
    }

}