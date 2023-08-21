package models

import Worker
import Strings
import services.InputService
import services.OutService

class Note(override val name: String) : Worker {
    private var content: String? = null
    override fun work() {
        while (true) {
            OutService.showNote(name, content == null)

            when (InputService().getInt()) {
                0 -> {
                    if (content == null) {
                        makeContent()
                    } else {
                        OutService.showNoteContent(name, content!!)
                    }
                }

                1 -> break
                else -> println(Strings.ERROR_WRONG_COMMAND)
            }
        }
    }

    private fun makeContent() {
        println("${Strings.NOTE_FILL}")
        content = InputService().getString()
    }
}
