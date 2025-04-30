class NotesScreen(private val archiveScreen: ArchiveScreen,var createNoteScreen: CreateNoteScreen? =null,var note: ScreenOfNote? =null): ScreenPrototype(){
    var archive: Archive? = null
    override fun display() {
        val notes = archive!!.notes
        createNoteScreen!!.notes = notes
        val size = notes.size
        println("\nЗаметки архива ${archive!!.title}:\n")
        putMenu<Note>(notes)
        val choise = readLine()
        when(choise?.toIntOrNull()){
            1->createNoteScreen?.display()
            in 2..size+1-> note?.display(notes[choise?.toIntOrNull()!!-2])
            size+2-> archiveScreen.display()
            else -> {
                println("Некорректный ввод")
                this.display()
            }
        }
    }
}
