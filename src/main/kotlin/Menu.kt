abstract class Menu {

    abstract val menuTitle: String
    abstract val menuItems: ArrayList<String>
    abstract fun inputData(): String
    abstract fun outputData(
        menuItems: ArrayList<String>,
        elementIndex: Int,
        hasError: Boolean,
        error: String
    )

    open var error: String = "Ошибки нет."

}