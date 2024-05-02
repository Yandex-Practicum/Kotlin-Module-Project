abstract class Menu {
    abstract fun show()
    abstract fun handleInput(input: String)

    open fun invalidInput() {
        println("Неверный ввод. Пожалуйста, введите цифру.")
    }

    abstract fun viewArchive(archive: Archive)
    abstract fun viewNote(note: Note)
}