interface ViewInterface {
    val title: String
    val mapOfMenu: MutableMap<String, () -> Unit>

    fun prepareToView ()
}