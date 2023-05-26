class CurrentChoice(var noEndProgram: Boolean) {
    var currentListMenu = ListMenu.ARCHIVES
    val listArchives: ArrayList<Archive> = arrayListOf()
    var currentArchive: Int = -1
    var currentNote: Int = -1
}
