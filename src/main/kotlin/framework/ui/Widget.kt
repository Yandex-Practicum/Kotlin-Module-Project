package main.kotlin.framework.ui

import main.kotlin.framework.navigation.Navigation

interface Widget {
    fun start()
    fun reDraw()
    fun destroy()
    fun inputChecker(menu: List<String>, onMenu: (menuNum: Int) -> Unit)
}

fun interface WidgetCycle {
    fun onStop(id: Int)
}

abstract class UWidget(val navigation: Navigation) : Widget {
    private var cycleListener: WidgetCycle? = null

    abstract var ui: Ui
    override fun start() {
        ui.draw()
    }

    override fun destroy() {
        cycleListener?.onStop(this.hashCode())
        cycleListener = null
    }

    fun registerListener(listener: WidgetCycle) {
        cycleListener = listener
    }

    override fun inputChecker(menu: List<String>, onMenu: (menuNum: Int) -> Unit) {
        print("Choose menu number: ")
        var input = readLine()
        var inProgress = true
        while (inProgress) {
            try {
                val number = input?.trim()?.toInt()
                if (number != null) {
                    if (number in menu.indices) {
                        onMenu(number)
                        inProgress = false
                        continue
                    }
                }
                input = read()
            } catch (e: Exception) {
                input = read()
            }
        }
    }

    private fun read(): String? {
        println("try again")
        print("Choose menu number: ")
        return readLine()
    }
}
