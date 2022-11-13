sealed class Screen {
    object AllArchives : Screen()
    class ChosenArchive(var archive: Archive): Screen()
    class ChosenNote(var note: Note): Screen()

}

