package view

import presenter.Presenter

abstract class Screen(val presenter: Presenter, val onBackPressed: () -> (Unit)) {
    abstract fun show()

}