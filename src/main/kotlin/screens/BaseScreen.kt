package screens

import InOutUtils

abstract class BaseScreen {
    abstract var tittleScreen: String
    abstract val menuList: MutableList<String>

    val utils = InOutUtils()

    open fun showMenu() {
        utils.showMenu(tittleScreen, menuList)
    }

    fun endPrintScreen() {
        utils.endPrintScreen()
    }
}