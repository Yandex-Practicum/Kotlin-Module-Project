package models

import Worker
import builders.NoteBuilder
import services.InputService
import services.OutService

class Archive(override val name: String) : Worker {
    private val notes: ArrayList<Worker> = ArrayList()

    override fun work(){
        while (true) {
            OutService.showArchive(name, notes)

            val command = InputService().getInt()

            if (notes.isEmpty()) {
                when (command) {
                    0 -> notes.add(NoteBuilder(InputService()).makeNote())
                    1 -> break
                    else -> println(Strings.ERROR_WRONG_COMMAND)
                }
            } else {
                when (command) {
                    0 -> notes.add(NoteBuilder(InputService()).makeNote())
                    in 1..notes.size -> notes[command - 1].work()
                    1 + notes.size -> break
                    else -> println(Strings.ERROR_WRONG_COMMAND)
                }
            }
        }
    }
}
