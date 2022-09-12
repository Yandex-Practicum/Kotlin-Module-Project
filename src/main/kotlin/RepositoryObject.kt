object RepositoryObject {
    val repository: MutableList<ArchiveEntity> = ArrayList()

    fun addMocks() {
        repository.add(
            ArchiveEntity(
                name = "Personal Tasks",
                notes = mutableListOf(
                    NoteEntity("buy something", "details"),
                    NoteEntity("sell something", "details"),
                    NoteEntity("just have fun", "details")
                )
            )
        )
        repository.add(
            ArchiveEntity(
                name = "Important Notes",
                notes = mutableListOf(
                    NoteEntity("1234", "details"),
                    NoteEntity("5678", "details"),
                    NoteEntity("90", "details")
                )
            )
        )
        repository.add(
            ArchiveEntity(
                name = "PumPam",
                notes = mutableListOf(
                    NoteEntity("something1", "details"),
                    NoteEntity("something2", "details"),
                    NoteEntity("fun", "details")
                )
            )
        )
    }
}