package ui.console

import ui.console.actions.CommonAction

class Dialog(val actions: Map<Int, CommonAction>) {
    fun showDialog() {
        actions.keys.forEach({ println("\t$it. ${actions[it]!!.title}") })
    }
}