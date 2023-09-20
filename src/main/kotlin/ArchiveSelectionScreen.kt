object ArchiveSelectionScreen : Selectable {
    override fun menuOutput() {

        val listFromHandler = mutableMapOf<String, (() -> Unit)?>()
        listFromHandler["\nВЫБОР АРХИВА:"] = null
        listFromHandler["\t0. Создать архив"] = { ArchiveCreationScreen.createObject() }


        for (a in ListOfArchives)
            listFromHandler["\t${ListOfArchives.indexOf(a) + 1}. ${a.name}"] =
                { NoteSelectionScreen.menuOutput(a) }
        listFromHandler["\t${ListOfArchives.size + 1}. Выход"] = { println("Программа завершена") }


        InputOutputHandler(listFromHandler).inputOutputOperations(this)
    }
}