import Data.Archieve

class ArchievePage{
    var archieves: MutableList<Archieve> = mutableListOf()

    fun addArchieve(note: Archieve){
        archieves.add(note)
    }

    fun showAllArchieves(){
        for(archieve in archieves){
            println(archieve.getArchName())
        }
    }

    fun chooseArchieve(archieveID: Int){
        println(archieves[archieveID])
    }
}