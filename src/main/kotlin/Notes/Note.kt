package Notes

import Menu.MenuItem

class Notes(
    val name: String,
    val textNote: String
): MenuItem {
    override val menuItem: String
        get() = name
}
