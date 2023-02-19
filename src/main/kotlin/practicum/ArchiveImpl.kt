package com.example.practicumkotlin.practicum

class Menu<T, U> : InterfaceApp<T,U> {

    val mapArchive: MutableMap<T,MutableList<U>> = mutableMapOf()

    override fun getItem(item: T): T {
        if (mapArchive.containsKey(item)) {
            return item
        } else {
            throw Exception("Такого элемента нет")
        }
    }


    override fun addArchive(item: T) {
    mapArchive[item] = mutableListOf()
    }

    override fun addNote(item: T, note: U) {
        if(mapArchive.containsKey(item)) {
            mapArchive[item] = mutableListOf(note)
            println(mapArchive)
        } else {
            throw  Exception("Такого архива нет")
        }
    }

}