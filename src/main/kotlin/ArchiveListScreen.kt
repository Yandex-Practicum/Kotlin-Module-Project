class ArchiveListScreen(private var archiveList: MutableList<Archive>): Screen() {


    override fun goToNextScreen(i: Int) {
        val noteListScreen = NoteListScreen(archiveList[i])
        noteListScreen.showScreen(archiveList[i].noteList)
    }
}