package screens.interfaces

import MenuLogic
import entities.MenuItem

interface Screen {
    val menu: MutableList<MenuItem>
    val menuLogic: MenuLogic

}