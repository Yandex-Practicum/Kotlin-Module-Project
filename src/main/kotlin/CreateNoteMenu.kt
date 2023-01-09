import java.util.*

object CreateNoteMenu: Menu() {
    override val menuItems = listOf(
        "Ввести имя заметки, содержимое и сохранить ее",
        "Выход"
    )
    override val header = "Меню создания заметки:"

    private fun enterNameAndContentAndSaveIt() {
        println("Введите имя заметки:")
        val responseName = Scanner(System.`in`).nextLine()
        println("Введите содержимое заметки:")
        val responseContent = Scanner(System.`in`).nextLine()
        val note = Note(responseName, responseContent)
        val checkList: List<String>? = App.currentArchive?.notes?.map { it.name }
        if (checkList != null) {
            if (responseName !in checkList) {
                App.currentArchive?.addNote(note)
                println("Заметка с именем '$responseName' в архиве '${App.currentArchive?.name}' успешно создана.")
            } else {
                println("Заметка с именем '$responseName' в архиве '${App.currentArchive?.name}' уже существует." +
                        " Попробуйте еще раз с другим именем.")
            }
        }
    }

    override fun runActions(response: String): Boolean {
        return when (response.toInt()) {
            menuItems.firstIndex -> { enterNameAndContentAndSaveIt(); true}
            else -> { exit(); false}
        }
    }

    override fun exit() {
        App.currentArchive?.execute()
    }
}