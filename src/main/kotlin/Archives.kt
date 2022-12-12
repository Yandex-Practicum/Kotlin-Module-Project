data class Archives(
    var listsOfNotes : HashMap<String, NotesList> = HashMap(),
    var listNames: HashSet<String> = HashSet()
):Choise(title = "NoteList", list = listNames)
{
    private var lastOpened : NotesList? = null

    fun createNotesList(){
        val title = getTitle(2)
        listNames.add(title)
        listsOfNotes[title] = NotesList(title)
        println("The archive was created successfully")
    }

    fun showNotesLists() {
        showElements()
    }

    fun deleteNoteList(){
        val title = getTitle(1)
        listNames.remove(title)
        listsOfNotes.remove(title)
        println("Archive successfully deleted")
    }

    fun openNoteList(){
        val title = getTitle(1)
        listsOfNotes[title]?.showNotes()
        lastOpened= listsOfNotes[title]
    }
    fun makeNewNote(){
        lastOpened?.createNote()
    }
    fun showMyNotes(){
        lastOpened?.showNotes()
    }
    fun deleteMyNote(){
        lastOpened?.deleteNote()
    }
    fun openMyNote(){
        lastOpened?.openNote()
    }
    fun redactMyNote(){
        lastOpened?.redactNote()
    }
    fun cleanMyNote(){
        lastOpened?.cleanNote()
    }
    fun backFromNoteList(){
        lastOpened=null
        showNotesLists()
    }
}
