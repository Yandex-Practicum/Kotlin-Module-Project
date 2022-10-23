fun main() {
    mainLoop@while (true) { // App life cycle
        when(NoteApp.currentState) {
            State.BEGIN -> NoteApp.onBegin()
            State.ARCHIVE_CREATE -> NoteApp.onArchiveCreate()
            State.ARCHIVE_CHOOSE -> NoteApp.onArchiveChoose()
            State.NOTE_CREATE -> NoteApp.onNoteCreate()
            State.NOTE_CHOOSE -> NoteApp.onNoteChoose()
            State.VIEW_NOTE -> NoteApp.onViewNote()
            State.EXIT -> {
                NoteApp.onExit()
                break@mainLoop
            }
        }
    }
}
