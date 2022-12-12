import java.util.*

fun main() {
    val read: Scanner = Scanner(System.`in`)
    var archive: Archives = Archives()
    var flag = true
    println("Let`s start")
    printCommandList()
    archive.showNotesLists()
    var command = read.nextLine()
    while (flag){
        when (command){
            "Create Archive" -> archive.createNotesList()
            "Show Archives" -> archive.showNotesLists()
            "Delete Archive" -> archive.deleteNoteList()
            "Open Archive" -> archive.openNoteList()
            "Back" -> flag=false
            else -> println("!Wrong command!")
        }
        if (flag)
        command = read.nextLine()
    }
}
