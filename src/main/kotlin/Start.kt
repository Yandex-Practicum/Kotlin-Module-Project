class Start: NavigationListener {
    private var state = State.CHOOSE_ARCHIVE
    fun start()  {
        println("Привет")
        val screen: Screen = Screen(this)
        while (true) {
            when (state) {
                State.CHOOSE_ARCHIVE -> screen.chooseArchiveScreen()
                State.ADD_ARCHIVE -> screen.addNewArchive()
                State.OPEN_ARCHIVE -> screen.openArchive()
                State.ADD_NOTE -> screen.makeNote()
                State.OPEN_NOTE -> screen.openNote()
                State.EXIT -> break
            }
        }
    }

    override fun state(state: State) {
        this.state = state
    }

    override fun exit() {
        this.state = State.EXIT
    }
}
