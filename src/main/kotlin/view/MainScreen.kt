package view

import presenter.Presenter
const val CHOOSE_ARCHIVE = "1 - Выбор архива"
const val CREATE_ARCHIVE = "2 - Создание архива"
const val EXIT = "0 - Выход"
class MainScreen(presenter: Presenter) :Screen(presenter) {
    override fun show() {
        println(CHOOSE_ARCHIVE + "\n" +
                CREATE_ARCHIVE + "\n" +
                EXIT)
    }
}