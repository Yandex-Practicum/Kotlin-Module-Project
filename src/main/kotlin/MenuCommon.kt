abstract class MenuCommon(private val typeElement: TitleTypes, private val archName: String?) {
    //метод onCreate() - общий для окна "Архивы" и для "Заметки", в нем - отображение пунктов меню
    fun onCreate() {
        NoteTools.printArchiveNotesHead(typeElement)
        if (typeElement == TitleTypes.NOTES) {
            archName?.let { println("Работа с архивом: $archName") }
        }
        NoteTools.printContext(typeElement)
        when (NoteTools.waitUserResponse(UserResponseType.SELECTED_MENU, 1, 3)) {
            TitleNamesText.EXIT.order.toString() -> {
                goPrevious()
            }

            TitleNamesText.CREATE_ARCHIVE.order.toString() -> {
                createElement()
            }

            TitleNamesText.SELECT_ARCHIVE.order.toString() -> {
                showAllElements()
            }
        }
    }

    //реализация этих методов будет зависеть от архива или заметки
    abstract fun goPrevious()
    abstract fun goNext()
    abstract fun createElement()
    abstract fun selectElement()
    abstract fun showAllElements()
}
