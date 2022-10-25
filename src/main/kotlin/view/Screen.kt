package view

import presenter.Presenter

abstract class Screen(val presenter: Presenter) {

    abstract fun show()
}