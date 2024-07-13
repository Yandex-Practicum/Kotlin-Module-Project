

open class ArchivesBox: WarningsText(), ExitAndWarningFlag {
    var archives: HashMap<Int, Archive> = HashMap()
        private set

    override fun getExitNum(): Int {
        return if (archives.keys.isEmpty()) 1 else archives.keys.max()+1
    }

    override fun checkNum(num: Int): Boolean {
        return archives.keys.contains(num)
    }

    fun addArchive(archive: Archive) {
        if (archives.keys.isEmpty()) archives.put(1, archive)
        else archives.put(archives.keys.max()+1, archive)
    }

    fun showAllArchives() {
        println("Список архивов:")
        println("0. Создать архив")
        if (archives.keys.isNotEmpty()) {
            archives.keys.forEach {
                println("$it. ${archives.get(it)?.archiveName}")
            }
        }
        println("${getExitNum()}. Выход")
    }

    fun showArchiveNotes(archiveNum: Int) {
        println("Список заметок")
        println("0. Создать заметку")
        val lst: ArrayList<Note> = getArchive(archiveNum)!!.archiveNotes
        for (i: Int in lst.indices) {
            println("${i+1} ${lst.get(i).name}")
        }
        println("${lst.size+1} Выход")
    }

    fun getArchive(archiveNum: Int): Archive? {
        return archives.get(archiveNum)
    }

}
