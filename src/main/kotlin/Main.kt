val ListOfArchives = mutableListOf<Archive>()
fun main(args: Array<String>) {

    println("\n --------------------- ")
    println("|| Программа ЗАМЕТКИ ||")
    println(" --------------------- ")
    
    for (a in ListOfArchives)
        println("\t${ListOfArchives.indexOf(a)}. ${a.name}")

    ArchiveSelectionScreen.menuOutput()
}
