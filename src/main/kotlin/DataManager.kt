class ProgramManager {
    val listOfArchive = mutableListOf<Archive>()

    companion object {
        const val EXIT_WORLD = "EXIT"
        const val CREATE_ARCHIVE = "CREATE_ARCH"
        const val CREATE_NOTE = "CREATE_NOTE"
    }

    fun getMainMenuOption() : Map<String, String>{
        val mapOfCommand = mutableMapOf<String, String>()
        mapOfCommand["Создать"] = CREATE_ARCHIVE
        for(archive in listOfArchive){
            mapOfCommand[archive.name] = archive.name
        }
        mapOfCommand["Выйти"] = EXIT_WORLD
        return mapOfCommand
    }

    fun createArchive(name : String) : Result<MutableList<Archive>> {
        for(archive in listOfArchive){
            if(name == archive.name){
                Result.Error("Архив с названием $name уже есть!")
            }
        }
        val newArchive = Archive(name)
        listOfArchive.add(newArchive)
        return Result.Success(listOfArchive)
    }


    fun createNote(archive :Archive, noteName : String) : Result<MutableList<Note>> {

    }

}

data class Option(val name : String){

}