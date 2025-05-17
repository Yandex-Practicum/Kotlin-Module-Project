package service

import model.BaseModel
import model.Node

interface OutputService<T:BaseModel> {
    fun consoleOutput(items: List<T>, currentItem: T?, isSaveMenu: Boolean)
    fun consoleOutput(nameNode: String)
    fun consoleOutput(currentNode: Node?)
}