val ListOfArchives = mutableListOf<Archive>()
fun main(args: Array<String>) {

    ListOfArchives.forEach() { println("${it.name} + ${it.notes}") }

    for (a in ListOfArchives)
        println("\t${ListOfArchives.indexOf(a)}. ${a.name}")

    ArchiveSelectionScreen.menuOutput()
}