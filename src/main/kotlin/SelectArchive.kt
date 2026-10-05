class SelectArchive(val archivesList: MutableList<DataArchive>) {
    fun watch() {
        if (archivesList.isEmpty()) {
            println("Нет архивов")
            return
        }
        val items = mutableListOf<Pair<String, () -> Unit>>()
        archivesList.forEach { archive ->
            items.add(archive.name to { openArchive(archive) })
        }
        val nav = Navigation("Выберите архив", items)
        items.add("Назад" to { nav.running = false })
        nav.watch()
    }
    fun openArchive(archive: DataArchive) {
        println("Открыт архив: ${archive.name}")
        NoteScreen(archive.notes).watch()
    }
}//возможно можно объединить логику SelectArchive и SelectNote через дженерики, но честно скажу моего уровня знаний работы с ними пока недостаточно