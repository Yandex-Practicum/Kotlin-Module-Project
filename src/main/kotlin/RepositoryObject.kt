object RepositoryObject {
    val repository: MutableList<ArchiveEntity> = ArrayList()

    fun addMocks() {
        repository.add(
            ArchiveEntity(
                name = "Personal Tasks",
                notes = mutableListOf(
                    NoteEntity(name = "buy something"),
                    NoteEntity(name = "sell something"),
                    NoteEntity(name = "just have fun")
                )
            )
        )
        repository.add(
            ArchiveEntity(
                name = "Important Notes",
                notes = mutableListOf(
                    NoteEntity(name = "1234"),
                    NoteEntity(name = "5678"),
                    NoteEntity(name = "90")
                )
            )
        )
        repository.add(
            ArchiveEntity(
                name = "PumPam",
                notes = mutableListOf(
                    NoteEntity(name = "something1"),
                    NoteEntity(name = "something2"),
                    NoteEntity(name = "fun")
                )
            )
        )
    }
}