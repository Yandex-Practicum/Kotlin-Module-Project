package core.menu

fun createPickerMenu(createNode: MenuNode.Create, items: List<MenuNode>): List<MenuNode>{
    val menu = mutableListOf<MenuNode>()
    menu.add(createNode)
    menu.addAll(items)
    menu.add(MenuNode.Exit)
    return menu.toList()
}
