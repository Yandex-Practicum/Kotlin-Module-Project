package core.menu

import navigation.Screens

sealed class MenuNode(
    val name: String
) {
    object Exit : MenuNode("Выход")
    class Create(name: String, val destination: Screens) : MenuNode(name)
    class Pick(name: String, val destination: Screens) : MenuNode(name)
}
