class ArchiveEntity(
    name: String,
    val notes: MutableList<NoteEntity> = ArrayList(),
): BaseEntity(name)
