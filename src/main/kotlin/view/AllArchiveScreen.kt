package view

import presenter.Presenter

class AllArchiveScreen(presenter: Presenter) : Screen(presenter) {
    override fun show() {
        println("all archives: ")
        presenter.archives.forEachIndexed { index, archive ->
            println("${index + 1} ${archive.name}")
        }
    }
}