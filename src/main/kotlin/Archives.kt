data class Archives(
    var listsOfNotes : HashMap<String, NotesList> = HashMap(),
    var listNames: HashSet<String> = HashSet()
):Choise(title = "NoteList", list = listNames)
{
    fun createNotesList(){
        val title = getTitle(2)
        listNames.add(title)
        listsOfNotes.set(title, NotesList(title))
        println("The archive was created successfully")
    }

    fun showNotesLists() {
        showElements()
    }

    fun deleteNoteList(){
        val title = getTitle(1)
        listNames.remove(title)
        listsOfNotes.remove(title)
    }

    fun openNoteList(){
        val title = getTitle(1)
        listsOfNotes.get(title)?.showNotes()
    }
}
