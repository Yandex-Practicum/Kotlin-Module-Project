sealed class Screen {
    class ShowNote(val note: Note) : Screen()
    class ShowArchive(val archive: Arch) : Screen()
    class CreateNote(val archive: Arch) : Screen()
    object ShowAllArchives : Screen()
    object CreateArchive : Screen()
}