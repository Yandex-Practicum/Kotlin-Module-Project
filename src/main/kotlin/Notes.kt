interface Notes {
    abstract val parent:Notes
    abstract val titlesList: MutableMap<Int, Notes>
    abstract fun getListOfContent() : MutableList<Int>
}

