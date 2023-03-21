class ProgramManager {
    val listOfArchive = mutableListOf<Archive>()

    companion object {
        const val EXIT_WORLD = "Выйти"
        const val CREATE_ARCHIVE = "Создать архив"
        const val CREATE_NOTE = "Создать заметку"
        const val EXIT_ARCHIVE = "Выйти из архива"
    }

    fun isStringInt(str: String): Boolean {
        return str.toIntOrNull() != null
    }

    fun checkUserInput(number: Int, commandList: List<String>): Boolean {
        if (number > commandList.size) {
            println("Число больше")
            return false
        } else if (number < 0) {
            println("Число меньше")
            return false
        }
        return if (commandList.contains(commandList[number])) {
            true
        } else {
            println("Команды нет в списке")
            false
        }

    }

    fun getMainMenuOption(): List<String> {
        val listOfCommand = mutableListOf<String>()
        listOfCommand.add(CREATE_ARCHIVE)
        for (archive in listOfArchive) {
            listOfCommand.add(archive.name)
        }
        listOfCommand.add(EXIT_WORLD)
        return listOfCommand
    }

    fun getArchiveMenu(name : String) : List<String> {
        val archive = getArchive(name)
        val listOfCommand = mutableListOf<String>()
        listOfCommand.add(CREATE_NOTE)
        for (note in archive.getNoteToList()) {
            listOfCommand.add(note.name)
        }
        listOfCommand.add(EXIT_ARCHIVE)
        return listOfCommand
    }

    fun getArchive(name : String): Archive {
        lateinit var foundArchive : Archive
        for(archive in listOfArchive){
            if(archive.name === name){
                foundArchive = archive
            }
        }
        return foundArchive
    }

    fun createArchive(name: String){
        val newArchive = Archive(name)
        listOfArchive.add(newArchive)
    }
}