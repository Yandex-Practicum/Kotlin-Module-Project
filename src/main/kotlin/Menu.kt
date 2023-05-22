abstract class Menu() {

    abstract fun createMenu(
        currentChoice: CurrentChoice
    ): MutableMap<Int, MenuItem>
}