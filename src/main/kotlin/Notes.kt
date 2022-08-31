//interface Notes {
//    abstract val parent: Notes
//    abstract val titlesList: MutableMap<Int, Notes>
//    abstract fun getListOfContent() : MutableList<Int>
//}

interface Notes {
    abstract val parent: Notes
    fun <X>getTitlesList(): MutableMap<Int, X>
//    abstract fun getListOfContent() : MutableList<Int>
}