package menu

abstract class AbstractMenu {

    abstract fun inputAndCheckCommand(): String

    abstract fun createNewOne()

    abstract fun showMenu()

    abstract fun checkName(): String
}