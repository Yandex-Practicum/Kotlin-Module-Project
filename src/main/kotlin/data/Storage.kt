package data

import models.Archive
import java.util.*

object Storage {

    val sc = Scanner(System.`in`)

    private val storage = mutableListOf<Archive>()

    fun createArchive(name: String) {
        storage.add(Archive(name))
    }

    fun getArchive(index: Int): Archive {
        return storage[index]
    }

    fun existArchive(index: Int) : Boolean {
        return  index >= 0 && index <= storage.size
    }


    fun getArchives(): MutableList<Archive> {
        return storage //.mapIndexed { i, archive -> "${i + 2} - $archive \n" }
    }
}