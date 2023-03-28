import Archive.ArchiveMenu

fun main() {
    val archiveMenu = ArchiveMenu()
    archiveMenu.interact()
}
interface Menu{
    fun show()
    fun add()
}

