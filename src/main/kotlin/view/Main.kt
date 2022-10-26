package view

import presenter.Presenter
import kotlin.system.exitProcess

fun main() {
    AllArchiveScreen(Presenter, ::exit).show()
}

fun exit() {
    println("Пока...")
    exitProcess(0)
}
