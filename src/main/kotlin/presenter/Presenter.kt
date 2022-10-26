package presenter

import model.Archive
import kotlin.Exception


object Presenter {
    val archives = mutableListOf<Archive>()

    fun addNewArchive(name: String){
       archives.add(Archive(name))
    }

    fun chooseArchive(num : Int):Archive?{
        return try {
            archives[num-1]
        }catch (e: Exception){
            null
        }
    }


}