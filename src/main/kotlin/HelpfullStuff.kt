interface GivingName {
    fun giveName():String
}

fun nameOfArchiveAndNumberOfExit (list: List<GivingName>) {
    var k = 1
    for (i in list) println("${k++}. -> press to enter the folder: ${i.giveName()}.")
    println("${list.size + 1}. -> press to exit.")
}