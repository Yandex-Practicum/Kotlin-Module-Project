class Screen {
    private val notes: MutableList<Note> = mutableListOf()
    private val archives: MutableList<Archive> = mutableListOf()
    val archiveScreen: ArchiveScreen = ArchiveScreen(archives)
    val createArchiveScreen: CreateArchiveScreen = CreateArchiveScreen(archives,archiveScreen)
    val notesScreen: NotesScreen = NotesScreen(archiveScreen)
    val createNoteScreen: CreateNoteScreen = CreateNoteScreen(notesScreen)
    val note: ScreenOfNote = ScreenOfNote(notesScreen)
    init {
        archiveScreen.createArchiveScreen = createArchiveScreen
        archiveScreen.notesScreen = notesScreen
        notesScreen.createNoteScreen = createNoteScreen
        notesScreen.note = note
    }
    //val archivePair: PairScreens<ArchiveScreen, CreateArchiveScreen> = PairScreens(archiveScreen,createArchiveScreen)
    //val notePair: PairScreens<NotesScreen,CreateNoteScreen> = PairScreens(notesScreen,createNoteScreen)
}