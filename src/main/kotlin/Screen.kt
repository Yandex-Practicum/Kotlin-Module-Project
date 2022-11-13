sealed interface Screen {

    data class CreateNote(val archives: Archives) : Screen
    data class OpenArchive(val archives: Archives) : Screen
    data class ShowNote(val note: Note) : Screen
    object MainScreen : Screen
    object CreateArchive : Screen
}