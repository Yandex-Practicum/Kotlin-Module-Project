abstract class Screen(val nextScreens: (AllScreens, Any?) -> Unit, val exitScreen: () -> Unit) {
    abstract fun printContent()
    open fun exit(){
        exitScreen()
    }

}