interface CreateInterface {
    val title: String
    var tempData: String
    val backToMenu: () -> Unit

    fun createFromInput ()
}