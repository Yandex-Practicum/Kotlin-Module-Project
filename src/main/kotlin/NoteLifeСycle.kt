interface NoteLifeCycle {
    var currentState: State /** текущее состояние жизненного цикла **/
    fun onBegin()
    fun onArchiveCreate()
    fun onArchiveChoose()
    fun onNoteCreate()
    fun onNoteChoose()
    fun onViewNote()
    fun onExit()
}
