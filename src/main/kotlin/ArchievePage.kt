import Data.Archieve

class ArchievePage{
    var archieves = HashMap<Int, Archieve>()

    fun isInputCorrect(value: String) : Boolean {
        try {
            value.toInt()
            return true
        } catch (e: NumberFormatException){
            return false
        }
    }

    fun addArchieve(note: Archieve){
        archieves[archieves.size+1] = note
        println("Архив добавлен")
    }

    fun showAllArchieves() : String {
        if(archieves.size > 0) {
            for (archieve in archieves){
                println(archieve.key.toString() + ". " + archieve.value.name)
            }
        }
        return "Список пуст"
    }

    fun chooseArchieve(archieveID: Int) : Archieve? {
        return archieves[archieveID]
    }
}