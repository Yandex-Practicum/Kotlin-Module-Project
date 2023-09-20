object NoteSelectionScreen : Selectable {
    override fun menuOutput(archive: Archive) {
        val listFromHandler = mutableMapOf<String, (() -> Unit)?>()
        listFromHandler["\nВЫБОР ЗАМЕТОК:"] = null
        listFromHandler["\nАрхив: ${archive.name}"] = null
        listFromHandler["\t0. Создать заметку"] = { NoteCreationScreen.createObject(archive) }


        for (a in archive.notes)
            listFromHandler["\t${archive.notes.indexOf(a) + 1}. ${a.name}"] =
                { NoteScreen.showNote(a) }

        listFromHandler["\t${archive.notes.size + 1}. Выход"] =
            { ArchiveSelectionScreen.menuOutput() }

        InputOutputHandler(listFromHandler).inputOutputOperations(this)
    }
}
