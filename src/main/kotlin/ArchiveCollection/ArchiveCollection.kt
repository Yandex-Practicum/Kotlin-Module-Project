package ArchiveCollection

import Archive.Archive

object ArchiveCollection {
    private var mapOfArchives: MutableMap<String, Archive> = emptyMap<String, Archive>() as MutableMap<String, Archive>

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