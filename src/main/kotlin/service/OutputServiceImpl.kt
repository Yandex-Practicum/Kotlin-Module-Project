package service

import model.BaseModel
import model.Node

class OutputServiceImpl<T : BaseModel>: OutputService<T> {
    private val goBack = "Вернуться назад"
    private val quit = "Выход"

    override fun consoleOutput(items: List<T>, currentItem:T?, isSaveMenu: Boolean) {
        if (!isSaveMenu)
            getListItems(items, currentItem)
        else
            saveItems(currentItem)
    }

    override fun consoleOutput(nameNode: String) {
        println("Введите текст заметки \"${nameNode}\"")
    }

    override fun consoleOutput(currentNode:Node?) {
        if (currentNode != null) {
            println("Просмотр заметки \"${currentNode.name}\"")
            println("Текст заметки: ${currentNode.text}")
        } else {println("Ошибка чтения заметки")}
        println("0 $goBack")
    }

    private fun getListItems(items: List<T>, currentItem: T?){
        var index = 0
        println("Выберите пункт меню")
        getTitle(currentItem)
        println("0. Создать  ${convertTypeToString(arrayOf("", "ку"), currentItem)}")
        index++
        for (baseModel in items) {
            println("$index. ${baseModel.name}")
            index++
        }
        println("$index. ${getStringQuit(currentItem)}")
    }

    private fun saveItems(currentItem: T?){
        println("Введите название ${convertTypeToString(arrayOf("а", "ки"), currentItem)}:")
    }

    private fun convertTypeToString(endingOfWord: Array<String>, currentArchive: T?): String {
        return if (currentArchive == null)
            "архив${endingOfWord[0]}"
        else
            "замет${endingOfWord[1]}"
    }

    private fun getTitle(currentItem: T?){
        if (currentItem == null)
            println("Список ${convertTypeToString(arrayOf("ов", "ок"), currentItem)}:")
        else
            println("Список ${convertTypeToString(arrayOf("ов", "ок"), currentItem)} архива \"${currentItem.name}\"")
    }

    private fun getStringQuit(currentItem: T?): String{
        if (currentItem == null)
            return quit
        return goBack
    }
}