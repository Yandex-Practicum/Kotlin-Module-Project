package com.example.practicumkotlin

import kotlin.String

class ArchiveImpl : Manipulation {


    var listArchive: MutableMap<String, List<String>> = mutableMapOf()
    var listNote: MutableList<String> = mutableListOf()


    override fun createArchive(titleArchive: String) {
        if (titleArchive != null) {
            listArchive[titleArchive] = listOf()
        } else {
            println("Введите название архива")
        }
    }

    override fun createNote(strNote: String): MutableList<String> {
        if (strNote != null) {
            listNote.add(strNote)
        } else {
            println("Введите заметка")
        }
        return listNote
    }

    override fun addNoteToTheArchive(titleArchive: String,strNote: String) {
        if(listArchive.containsKey(titleArchive)) {
            listArchive[titleArchive] = createNote(strNote)
        }
    }

    override fun printNote(titleArchive: String) {
        if(listArchive.containsKey(titleArchive)) {
           println(listArchive.getValue(titleArchive))
        } else {
            println("Такого архива не существует")
        }
    }
}