package Screen

import Menu

class Screen(val name: String, val menu: Menu) {
    fun showMenu() = println(menu)
}