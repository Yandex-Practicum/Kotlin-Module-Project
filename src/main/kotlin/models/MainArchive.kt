package models

import builders.ArchiveBuilder
import Worker
import Strings
import services.InputService
import services.OutService
import kotlin.collections.ArrayList

class MainArchive(override val name: String): Worker {
    private val archives: ArrayList<Worker> = ArrayList()

    override fun work() {
        while (true) {
            OutService.showMain(archives)

            val command = InputService().getInt()

            if (archives.isEmpty()) {
                when (command) {
                    0 -> archives.add(ArchiveBuilder(InputService()).makeArchive())
                    1 -> break
                    else -> println(Strings.ERROR_WRONG_COMMAND)
                }
            } else {
                when (command) {
                    0 -> archives.add(ArchiveBuilder(InputService()).makeArchive())
                    in 1..archives.size -> archives[command - 1].work()
                    1 + archives.size -> break
                    else -> println(Strings.ERROR_WRONG_COMMAND)
                }
            }
        }
    }
}