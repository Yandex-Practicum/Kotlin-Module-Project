package services

import Worker
import Strings

object OutService {

    fun showMain(content: ArrayList<Worker>) {
        println(
            "${Strings.ARCHIVE_LIST}\n" +
                    "${Strings.ARCHIVE_MAKE}"
        )
        show(content)
    }

    fun showArchive(archiveName: String, content: ArrayList<Worker>) {
        println(
            "${Strings.ARCHIVE_INTRODUCE}$archiveName\n" +
                    "${Strings.NOTE_MAKE}"
        )
        show(content)
    }

    fun showNote(noteName: String, noteFilled: Boolean) {
        println(
            "${Strings.NOTE_INTRODUCE}$noteName\n" +
                    "${if (noteFilled) Strings.NOTE_FILL_COMMAND else Strings.NOTE_READ}\n" +
                    "1. ${Strings.COMMAND_EXIT}\n" +
                    "${Strings.COMMAND_ENTER}"
        )
    }

    fun showNoteContent(noteName: String, noteContent: String) {
        println(
            "${Strings.NOTE_SHOW_CONTENT}$noteName\n" +
                    noteContent
        )
    }

    private fun show(content: ArrayList<Worker>) {
        if (content.isEmpty()) {
            println("1. ${Strings.COMMAND_EXIT}")
        } else {
            content.forEachIndexed { index, displayed -> println("${index + 1}. ${displayed.name}") }
            println("${content.size + 1}. ${Strings.COMMAND_EXIT}")
        }
        println(Strings.COMMAND_ENTER)
    }
}