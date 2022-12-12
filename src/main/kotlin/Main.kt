import java.util.*

fun main() {
    val read = Scanner(System.`in`)
    val archive = Archives()
    var screen = "start"
    var flag = true
    println("Let`s start")
    printCommandList()
    archive.showNotesLists()
    var command = read.nextLine()
    while (flag){
        when (command){
            "Create Archive" -> {
                if (screen == "start")
                    archive.createNotesList()
                else
                    println("First get back to archives list")
            }
            "Show Archives" -> {
                if (screen == "start")
                    archive.showNotesLists()
                else
                    println("First get back to archives list")
            }
            "Delete Archive" -> {
                if (screen == "start")
                    archive.deleteNoteList()
                else
                    println("First get back to archives list")
            }
            "Open Archive" -> {
                if (screen == "start") {
                    archive.openNoteList()
                    screen = "noteList"
                }
                else
                    println("First get back to archives list")
            }

            "Create Note" -> {
                if (screen == "noteList")
                    archive.makeNewNote()
                else
                    println("First open the archive")
            }
            "Show Notes" -> {
                if (screen == "noteList")
                    archive.showMyNotes()
                else
                    println("First open the archive")
            }
            "Delete Note" -> {
                if (screen == "noteList")
                    archive.deleteMyNote()
                else
                    println("First open the archive")
            }
            "Open Note" -> {
                if (screen == "noteList") {
                    archive.openMyNote()
                    screen = "note"
                }
                else
                    println("First open the archive")
            }
            "Redact Note" -> {
                if (screen == "noteList")
                    archive.redactMyNote()
                else
                    println("First open the archive")
            }
            "Clean Note" -> {
                if (screen == "noteList")
                    archive.cleanMyNote()
                else
                    println("First open the archive")
            }

            "Back" -> {
                when (screen) {
                    "start" -> flag=false
                    "noteList" -> {
                        archive.backFromNoteList()
                        screen = "start"
                    }
                    "note" -> {
                        archive.showMyNotes()
                        screen = "noteList"
                    }
                }
            }

            else -> println("!Wrong command!")
        }
        if (flag)
        command = read.nextLine()
    }
}
