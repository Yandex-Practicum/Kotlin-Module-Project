package core.screens

import core.menu.MenuNode
import navigation.NavController
import navigation.Screens
import storage.LocalDataSource
import java.util.*

abstract class BaseScreen : Screen {
    private var menu: List<MenuNode>? = null
    protected abstract val title: String
    private val navController: NavController by lazy { NavController.getInstance() }
    protected val repository: LocalDataSource by lazy { LocalDataSource.getInstance() }

    override fun init() {
        menu = resolveMenu()
        start()
    }

    abstract fun start()

    fun exitScreen(){
        navController.popUp()
    }

    fun isMenuInputValid(input: Int): Boolean{
        return input >= 0 && input <= (menu?.lastIndex ?: 0)
    }

    fun goToScreen(screen: Screens) {
        navController.goTo(screen)
    }

    fun getMenuNode(menuIndex: Int): MenuNode? {
        return menu?.get(menuIndex)
    }

    protected abstract fun resolveMenu(): List<MenuNode>

    protected fun waitForInput(onInput: (String) -> Unit) {
        onInput(Scanner(System.`in`).nextLine())
    }

    protected fun showMenu() {
        println("$title:")
        resolveMenu().forEachIndexed { index, s ->
            println("$index. ${s.name}")
        }
    }
}
