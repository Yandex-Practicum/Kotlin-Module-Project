package view

import presenter.Presenter
import java.util.*

abstract class Screen(val presenter: Presenter, val onBackPressed: () -> (Unit)) {
    val scanner = Scanner(System.`in`)
    abstract fun show()

}