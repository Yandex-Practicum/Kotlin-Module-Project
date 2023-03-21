import java.util.*

class Archive(override var name: String) : Checkable {
    val listOfNote = mutableListOf<Note>()


    companion object {
        fun createArchive(dataManager: ProgramManager, listMainCommand : List<String>){
            val scanner = Scanner(System.`in`)
            while (true){
                println("Введите название архива")
                val userNameArchive = scanner.nextLine()
                if(userNameArchive == ProgramManager.EXIT_WORLD || userNameArchive == ProgramManager.CREATE_ARCHIVE){
                    println("Название не может быть командой")
                    continue
                }
                else if(listMainCommand.contains(userNameArchive)){
                    println("Архив с таким название уже есть")
                    continue
                }
                dataManager.createArchive(userNameArchive)
                break
            }
        }
    }

    fun workWithNotes(dataManager: ProgramManager){
        val scanner = Scanner(System.`in`)
        while (true){
            val archiveCommands = dataManager.getArchiveMenu(this.name)
            println("Список заметок:")
            for((index, value) in archiveCommands.withIndex()){
                println("$index. $value")
            }

            val input = scanner.nextLine()

            if(!dataManager.isStringInt(input)){
                println("Необходимо ввести число!")
                continue
            }

            val number = input.toInt()

            val checkCommand = dataManager.checkUserInput(number, archiveCommands)
            if(!checkCommand){
                continue
            }

            when(archiveCommands[number]){
                ProgramManager.EXIT_ARCHIVE -> {
                    break
                }
                ProgramManager.CREATE_NOTE -> {
                    Note.createNote(this, archiveCommands)
                    continue
                }
                else -> {
                    val note = this.getNote(archiveCommands[number])
                    note.openNote()
                }
            }
        }
    }

    fun getNote(name : String) : Note{
        lateinit var foundNote : Note
        for(note in listOfNote){
            if(note.name === name){
                foundNote = note
            }
        }
        return foundNote
    }

    fun getNoteToList() : MutableList<Note>{
        return listOfNote
    }
    fun addNoteToList(note : Note){
        listOfNote.add(note)
    }

}