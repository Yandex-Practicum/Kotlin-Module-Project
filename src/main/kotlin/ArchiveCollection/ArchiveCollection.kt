package ArchiveCollection

import Archive.Archive

class ArchiveCollection(val name: String, var mapOfArchives: MutableMap<String, Archive>) {

    fun addArchive(archive: Archive) {
        mapOfArchives[archive.name] = archive
    }

    fun choseArchive(name: String): Archive? = mapOfArchives[name] ?: null

    override fun toString(): String {
        var listOfArchivesNames: String ="It is hole List of Archives: \n"
        for (key in mapOfArchives) listOfArchivesNames = listOfArchivesNames + " \n " + key
        return listOfArchivesNames
    }
}