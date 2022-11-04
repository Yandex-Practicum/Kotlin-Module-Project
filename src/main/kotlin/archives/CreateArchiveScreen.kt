package archives

import base.Archive
import base.BaseCreator
import base.Text
import listOfArchives
import java.util.*

object CreateArchiveScreen : BaseCreator<Archive>() {

    override fun greetings() {
        println("Создаем архив!")
        println("Введите название архива для его создания")
        println("Введите 0 для выхода")
    }

    override fun info() = Unit

    override fun someWork(textName: String, text: Text?) {
        listOfArchives.add(
            Archive(
                name = textName,
                listOfNotes = mutableListOf()
            )
        )
        println("Архив с названием <$textName> создан!")
    }
}