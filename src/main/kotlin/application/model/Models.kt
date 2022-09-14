package main.kotlin.application.model

import java.util.*

data class Archive(
    var id: UUID = UUID.randomUUID(),
    val name: String,
    val listOfNotes: Set<UUID> = emptySet()
)

data class Note(
    var id: UUID = UUID.randomUUID(),
    val note: String
)
