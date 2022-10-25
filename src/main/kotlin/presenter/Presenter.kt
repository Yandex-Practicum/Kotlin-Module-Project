package presenter

import model.Archive


class Presenter {

    val archives = mutableListOf<Archive>()


    fun addNewArchive(name: String){
       archives.add(Archive(name))
    }

    fun showAllArchives(){
        archives.forEachIndexed { index, archive ->
            println("$index ${archive.name}")
        }
    }

}