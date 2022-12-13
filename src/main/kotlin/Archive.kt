class Archive(val archiveName: String) {
    var archiveData: MutableList<Note> = mutableListOf()
    override fun toString(): String {
        return "archiveName = `${this.archiveName}` archiveData = ${this.archiveData}"
    }
}