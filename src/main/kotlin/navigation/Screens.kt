package navigation

sealed class Screens {
    object ArchivesList: Screens()
    class NotesList(val archiveId: Int): Screens()
    class Note(val id: Int): Screens()
    object CreateArchive: Screens()
    class CreateNote(val archiveId: Int): Screens()
}
