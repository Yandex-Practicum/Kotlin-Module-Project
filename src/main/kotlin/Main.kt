import views.ArchiveViewList

fun main() {
    val archive = ArchiveViewList(mutableListOf())
    archive.commandReader().invoke()
}