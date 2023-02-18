import java.util.Scanner

object ActionMenu {
    private val actionMenuList: MutableList<Archive> = mutableListOf()
    private val menuUtils: MenuUtils = MenuUtils()

    fun launch() {
        this.menuUtils.start()
    }

    fun addArchive(scanner: Scanner): Boolean {
        val archive = Archive.createArchive(scanner)
        actionMenuList.add(archive)
        menuUtils.dataList.add(
            MenuData(archive.name, action = { archive.archiveChoice.start(); true })
        )
        return true
    }
}