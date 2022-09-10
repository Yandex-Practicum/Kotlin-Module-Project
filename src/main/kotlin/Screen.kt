sealed class Screen {
    object ShowAllArchives : Screen()
    object CreateArchive : Screen()
    class ShowArchive(val archive: Archive) : Screen()
    class ShowNote(val note: Note) : Screen()
    class CreateNote(val archive: Archive) : Screen()
}