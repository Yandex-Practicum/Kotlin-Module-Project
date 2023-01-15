data class MenuItem(
    val name: String,
    val action: (MenuItem) -> Unit
)