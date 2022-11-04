package base

import java.util.*

abstract class BaseCreator<T> {

    fun createText(text: T?) {
        greetings()
        while (true) {
            val noteName = Scanner(System.`in`).nextLine().toString()
            if (noteName == "0") return
            info()

            someWork(noteName, text as? Text)
            break
        }
    }

    abstract fun greetings()
    abstract fun info()

    abstract fun someWork(textName: String, text: Text?)
}