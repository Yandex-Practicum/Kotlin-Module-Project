package ArchiveCollection

import AppState.AppState
import Archive.Archive
import Menu
import Note
import Screen.Screen


object ArchiveCollection {

    private var mapOfArchives: MutableMap<String, Archive> = mutableMapOf()
    private var openedArchive: Archive? = null

    private fun addArchive(massage: String) {
        mapOfArchives[massage] = Archive(name = massage)
    }

    override fun toString(): String {

        var archiveString = "It is the hole List of Archives: \n"
        mapOfArchives.forEach { (key, _) -> archiveString += "Name: $key; " }
        return archiveString
    }

    fun activityCreate(massage: String, screen: Screen): String {
        when (screen.menu) {
            Menu.CREATENOTE -> openedArchive!!.addNote(Note(textOfNote = massage))
            else -> addArchive(massage)
        }
        return screen.name
    }

    fun activityChose(screen: Screen): String {
        when (screen.menu) {
            Menu.CHOSEARCHIVE -> if (mapOfArchives.any()) {
                chooseArchive()
                return "choseNote"
            } else {
                println("You cant choose archive, there is no one has been created yet.")
                return screen.name
            }
            else -> if (openedArchive!!.mapOfNote.any() && openedArchive !== null) {
                chooseNote()
                return "noteView"
            } else {
                println("You cant choose archive, there is no one has been created yet.")
                return screen.name
            }
        }
    }

    private fun chooseArchive() {

        println("$ArchiveCollection \n Enter archive name")
        do {
            val name = AppState.readText()
            if (mapOfArchives.containsKey(name)) {
                openedArchive = mapOfArchives[name]
                return
            } else println("Wrong name, try again")
        } while (true)
    }

    private fun chooseNote() {
        println("$openedArchive \n Enter note name")
        do {
            val name = AppState.readText()
            if (openedArchive!!.mapOfNote.containsKey(name)) {
                println(openedArchive!!.mapOfNote[name])
                return
            } else println("Wrong name, try again")
        } while (true)
    }

}