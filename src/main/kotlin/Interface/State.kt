package Interface

import models.Archive
import models.Note

sealed interface State {
    object ArchiveListView : State
    class ArchiveView(val item: Archive) : State
    object ArchiveCreationView : State
    class NoteView(val item: Note) : State
    class NoteCreationView(val item: Archive) : State
}