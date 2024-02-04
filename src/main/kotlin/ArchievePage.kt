import Data.Archieve

class ArchievePage{
    var archieves = HashMap<Int, Archieve>()

    fun addArchieve(note: Archieve){
        archieves[archieves.size+1] = note
        println("Архив добавлен")
    }

    fun showAllArchieves() : String {
        if(archieves.size > 0) {
            for (archieve in archieves)
                return archieve.key.toString() + ". " + archieve.value.name
        }
        main()
        return "Список пуст"
    }

    fun chooseArchieve(archieveID: Int) : Archieve? {
        return archieves[archieveID]
    }
}