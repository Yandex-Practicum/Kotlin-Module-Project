import Data.Archieve

class ArchievePage{
    var archieves = HashMap<Int, Archieve>()

    fun addArchieve(note: Archieve){
        archieves[archieves.size+1] = note
        println("Архив добавлен")
    }

    fun showAllArchieves(){
        var counter = 0
        for(archieve in archieves){
            print(archieve.key)
            print(". ")
            println(archieve.value.name)
        }
    }

    fun chooseArchieve(archieveID: Int) : Archieve? {
        return archieves[archieveID]
    }
}