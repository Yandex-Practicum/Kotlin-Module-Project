class Logic: Choice {
    private var state = State.ARCHIVE_CHOOSE

    fun start() {
        println("Добро пожаловать в консольное приложение")
        val functions = Functions(this)
        while (true) {
            when (state) {
                State.ARCHIVE_CHOOSE -> functions.chooseArchive()
                State.ARCHIVE_OPEN -> functions.openArchive()
                State.ARCHIVE_CREATE -> functions.createArchive()
                State.NOTES_OPEN -> functions.openNotes()
                State.NOTES_CREATE -> functions.createNotes()
                State.EXIT -> break
            }
        }
    }

    override fun action(state: State) {
        this.state = state
    }

    override fun exit() {
        this.state = State.EXIT
    }
}