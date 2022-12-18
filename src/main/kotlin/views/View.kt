package views

abstract class View {
    var isEnd: Boolean = false
    abstract var viewName: String
    abstract fun showContent()
    abstract fun readCommand(): Int
    abstract fun commandReader()
    abstract fun exit()
}