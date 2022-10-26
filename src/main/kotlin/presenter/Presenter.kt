package presenter

import model.Archive
import view.AllArchiveScreen
import view.ArchiveCreationScreen
import view.Screen
import kotlin.Exception


class Presenter {

    val archives = mutableListOf<Archive>()

    val allArchivesScreen = AllArchiveScreen(this)
    val archiveCreationScreen = ArchiveCreationScreen(this)

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