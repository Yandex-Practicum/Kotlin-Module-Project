class MenuItem(
    val title: String,
    val action: () -> Unit,
    val exit: Boolean = false
)