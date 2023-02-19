package com.example.practicumkotlin

import kotlin.String

class ArchiveImpl : Manipulation {

    val listArchive: MutableMap<String, MutableList<String>> = mutableMapOf()

    override fun createArchive(titleArchive: String) {
        if (titleArchive != null) {
            listArchive[titleArchive] = mutableListOf()
        } else {
            println("Введите название архива")
        }
    }

    override fun addNoteToTheArchive(titleArchive: String, strNote: String) {
        if (listArchive.containsKey(titleArchive)) {
            val list = listArchive.getValue(titleArchive)
            list.add(strNote)
            listArchive[titleArchive] = list
        } else {
            println("Такого архива не существует")
        }
    }

    override fun printNote(titleArchive: String) {
        if (listArchive.containsKey(titleArchive)) {
            println(listArchive.getValue(titleArchive))
        } else {
            println("Такого архива не существует")
        }
    }
}


