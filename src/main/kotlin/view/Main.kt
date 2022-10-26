package view

import model.Archive
import model.Note
import presenter.Presenter
import kotlin.system.exitProcess

fun main() {
    val arch1 = Archive("путешествия").apply {
        notes.add(Note("Бали", "На бали можно серфить и там жарко"))
        notes.add(Note("Москва", "в Москве холодно"))
    }
    val arch2 = Archive("программирование").apply {
        notes.add(Note("Котлин", "Котлин классный"))
        notes.add(Note("Ковариантность", "Это мрак"))
    }

    val presenter = Presenter(
        mutableListOf(
            arch1,
            arch2
        )
    )

    AllArchiveScreen(presenter, ::exit).show()
}

fun exit() {
    println("Пока...")
    exitProcess(0)
}
