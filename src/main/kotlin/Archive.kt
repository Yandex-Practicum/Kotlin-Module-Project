package com.lesa.model

data class Archive(
    val title: String,
    val notes: MutableList<Note> = mutableListOf()
)