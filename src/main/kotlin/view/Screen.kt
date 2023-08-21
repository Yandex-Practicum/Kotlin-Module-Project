package view

import Strings
import models.MainArchive

object Screen {

    fun start(){
        println(Strings.PROGRAM_HELLO)
        MainArchive("").work()
        println(Strings.PROGRAM_GOODBYE)
    }

}