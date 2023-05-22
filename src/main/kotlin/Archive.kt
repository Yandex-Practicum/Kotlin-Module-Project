
data class Archive(var archiveName: String) {
    var notes: ArrayList<Note> = arrayListOf()
}

data class Note (var noteName: String) {
    var data: String = ""
}