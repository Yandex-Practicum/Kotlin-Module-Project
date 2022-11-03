package model

class MenuItem(
    val itemName: String,
    val action: () -> Unit
)