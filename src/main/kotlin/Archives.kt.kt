class Archives: Items<Archive>() {
    override var itemsList: List<Archive> = listOf()

    fun showArchives() {
        super.show()
        println("Archives shown")
    }
}