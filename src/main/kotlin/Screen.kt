import java.util.*

abstract class Screen (screenType: ScreenType){
    protected val scanner = Scanner(System.`in`)
    protected val menuRes: MenuResources

    init {
        menuRes = MenuResources(screenType)
    }

    open fun getScreenSpecificName(): String = ""

    protected fun renderMenu(items: List<Any>) {
        val screenCaption = menuRes.screenCaption.format(getScreenSpecificName())
        println("\n$screenCaption")
        println("-".repeat(screenCaption.length))
        if (items.isEmpty())
            println("\t${menuRes.listIsEmpty}")
        else
            items.forEachIndexed {i, item ->
                println("\t${i+1}: $item")
            }
        println("\ta: ${menuRes.addNewItem}")
        println("\tq: ${menuRes.exitScreen}")
        print("${menuRes.selectMenuItem}: ")
    } //> renderMenu()

    /* returns:
        >0 - selected menu item
        0 - input error
        -1 - create new item
        -2 - quit
    */
    protected fun selectMenuItem(maxN: Int): Int {
        val userInputText = scanner.nextLine()

        // process user input
        var selectedMenuItem = 0
        when (userInputText) {
            "a" -> selectedMenuItem = -1   // add new element
            "q" -> selectedMenuItem = -2   // quit current screen or program
            else -> {
                val userInputN = userInputText.toIntOrNull()
                if ((userInputN != null) && (userInputN > 0) && (userInputN <= maxN))
                    selectedMenuItem = userInputN
            }
        } //> when

        return selectedMenuItem
    } //> selectMenuItem()

    protected fun showErrorMessage(isEmptyItemList: Boolean) {
        if (isEmptyItemList)
            println(menuRes.inputErrorOnEmptyList)
        else
            println(menuRes.inputErrorOnFilledList)
    }

}