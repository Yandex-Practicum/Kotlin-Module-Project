abstract class Menu(protected val stack: MutableList<Menu>, protected val helper: MenuScanner) {
    abstract fun showMenu()

    protected fun goBack() {
        if (stack.isNotEmpty()) {
            stack.removeAt(stack.size - 1).showMenu()
        }
    }
}