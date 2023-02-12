package com.example.practicumkotlin

import kotlin.String

interface Manipulation {



    fun createArchive(titleArchive: String)
    fun createNote(strNote:String):MutableList<String>
    fun addNoteToTheArchive(titleArchive: String, strNote: String)
    fun printNote(titleArchive: String)


}