package main.kotlin.framework.navigation

import main.kotlin.framework.ui.UWidget
import main.kotlin.framework.ui.WidgetCycle
import java.util.*

interface Navigation {
    var navigationListener: NavigationListener?
    fun navigate(widget: UWidget)
}

fun interface NavigationListener {
    fun onStopApp()
}

class WidgetNavigation : Navigation, WidgetCycle {
    private val navigationStack = Stack<UWidget>()
    override var navigationListener: NavigationListener? = null

    override fun navigate(widget: UWidget) {
        navigationStack.add(widget)
        widget.registerListener(this)
        widget.start()
    }

    override fun onStop(id: Int) {
        //todo optimization
        if (navigationStack.isEmpty()) {
            navigationListener?.onStopApp()
            return
        }
        navigationStack.pop()

        if (navigationStack.isEmpty()) {
            navigationListener?.onStopApp()
            return
        }
        navigationStack.peek().apply {
            reDraw()
        }
    }
}
