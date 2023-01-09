import java.util.*

object CreateArchiveMenu: Menu() {
    override val menuItems = listOf(
        "Ввести имя архива и сохранить его",
        "Выход"
    )
    override val header = "Меню создания архива:"

    override fun runActions(response: String): Boolean {
        return when (response.toInt()) {
            menuItems.firstIndex -> {enterNameAndSave(); true}
            else -> {exit(); false}
        }
    }

    override fun exit() {
        ListOfArchivesMenu.execute()
    }

    private fun enterNameAndSave() {
        println("Введите имя архива:")
        val response = Scanner(System.`in`).nextLine()
        val archive = Archive(response)
        if (archive.name !in ListOfArchivesMenu.archives.map{it.name}) {
            ListOfArchivesMenu.addArchive(Archive(response))
            println("Архив с именем '$response' успешно создан.")
        } else {
            println("Архив с именем '$response' уже существует. Попробуйте еще раз с другим именем.")
        }
    }
}