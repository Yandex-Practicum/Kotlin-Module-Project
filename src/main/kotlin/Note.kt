open class Note: WarningsText(), ExitAndWarningFlag {
    var name:String = ""
        private set
    var content: String = ""
        private set

    override fun getExitNum(): Int {
        return 1
    }

    override fun checkNum(num: Int): Boolean {
        return  num==0 || num == 1
    }

    fun createNote(nameNote: String, contentNote: String): Boolean {
        if (nameNote.isBlank() || contentNote.isBlank()) {
            noteNameError()
            return false
        }
        else {
            name=nameNote
            content=contentNote
            return true
        }
    }

    fun addContentToNote(otherContent: String) {
        content+=" "+otherContent.trim()
    }

    fun openNote() {
        println("0. Добавить текст в заметку")
        println(content)
        println("1. Выход")
    }

}
