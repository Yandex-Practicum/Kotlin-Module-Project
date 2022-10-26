package presenter

import model.Archive

import kotlin.Exception

private const val NO_ARCHIVES = "архивов пока нет"
object Presenter {
    private val archives = mutableListOf<Archive>()

fun showAllArchives() {
    if (archives.size > 0) {
        archives.forEachIndexed { index, archive ->
            println("${index + 1} - ${archive.name}")
        }
    } else {
        println(NO_ARCHIVES)
    }
}
    fun addNewArchive(name: String){
       archives.add(Archive(name))
    }

    fun chooseArchive(num : Int):Archive{
           return archives[num-1]
    }


}