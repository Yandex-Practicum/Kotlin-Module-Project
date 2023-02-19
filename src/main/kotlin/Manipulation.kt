package com.example.practicumkotlin

import kotlin.String

interface Manipulation {

    fun createArchive(titleArchive: String)
    fun addNoteToTheArchive(titleArchive: String, strNote: String)
    fun printNote(titleArchive: String)


}