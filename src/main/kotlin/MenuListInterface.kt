interface MenuListInterface {
    abstract val title: String
    abstract val titlesList: MutableMap< Int,out MenuListInterface>
    abstract fun addContent(title: String)
}