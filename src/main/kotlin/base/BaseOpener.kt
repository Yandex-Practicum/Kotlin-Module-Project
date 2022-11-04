package base

import java.util.*

abstract class BaseOpener<T : Text> {

    companion object {
        const val NOTE_TEXT = "Заметка"
        const val ARCHIVE_TEXT = "Архив"
    }

    abstract fun greetings()
    abstract fun info()

    abstract fun someWork(text: T, stopLoop: () -> Unit)

    private var stopLoopFlag = true

    fun openText(text: List<Text>) {
        stopLoopFlag = true
        info()
        while (stopLoopFlag) {
            greetings()

            val name = Scanner(System.`in`).nextLine().toString()
            if (name == "0") return

            val archive = text.find { it.name == name }

            if (archive == null) {
                println("Ничего не найдено, введите корректное название или введите - <0> для выхода")
                continue
            }

            someWork(archive as T, ::stopLoop)
        }
    }

    private fun stopLoop() {
        stopLoopFlag = false
    }
}