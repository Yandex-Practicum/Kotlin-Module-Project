package presenter

import model.Archive


private const val NOTHING = "ничего нет"
object Presenter {
    private val archives = mutableListOf<Archive>()

fun showAllArchives() {
    if (archives.size > 0) {
        archives.forEachIndexed { index, archive ->
            println("${index + 1} - ${archive.name}")
        }
    } else {
        println(NOTHING)
    }
}
    fun showNotes(archive: Archive){
        if (archive.notes.isEmpty()){
            println(NOTHING)
        }else {
            archive.notes.forEachIndexed { index, note ->
                println("${index+1} - ${note.title}")
            }
        }
    }
    fun addNewArchive(name: String) {
        archives.add(Archive(name))
        println("архив $name создан")
    }

    fun chooseArchive(num : Int):Archive{
           return archives[num-1]
    }


}