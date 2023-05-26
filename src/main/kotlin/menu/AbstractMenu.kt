package menu

abstract class AbstractMenu {

    abstract fun inputAndCheckCommand():Char

    abstract fun createNewOne()

    abstract fun showMenu()

    abstract fun checkName(): String
}