data class Note (override val title: String) : MenuListInterface {

    override val titlesList: MutableMap<Int, out MenuListInterface> = mutableMapOf()

    override fun addContent(title: String) {
        println("Not yet implemented")
    }

}