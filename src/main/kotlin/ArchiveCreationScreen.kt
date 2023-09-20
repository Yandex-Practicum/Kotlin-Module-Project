import java.util.Scanner

object ArchiveCreationScreen : Creatable {
    override fun createObject() {
        val listFromHandler = mutableMapOf<String, (() -> Unit)?>()
        listFromHandler["\nСОЗДАНИЕ АРХИВА:"] = null
        listFromHandler["\tВведите название создаваемого архива:"] = {
            ListOfArchives.add(Archive(createArchiveName()))
        }
        listFromHandler["\tОперация успешно завершена."] = { ArchiveSelectionScreen.menuOutput() }
        InputOutputHandler(listFromHandler).inputOutputOperations(this)
    }

    private fun createArchiveName(): String {
        var name = ""
        var nameIsPossible: Boolean
        do {
            nameIsPossible = true
            name = Scanner(System.`in`).nextLine()
            ListOfArchives.forEach { if (name == it.name) nameIsPossible = false }
            if (!nameIsPossible || name == "") {
                println("\tНазвание архива не может быть пустой строкой, названия архивов не могут повторяться!")
                println("\tПовторите ввод:")
                continue
            }
            return name
        } while (true)
    }
}