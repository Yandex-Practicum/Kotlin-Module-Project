package builders

import services.InputService
import models.Note

class NoteBuilder(val inputService: InputService) {
    fun makeNote(): Note{
        println(Strings.NOTE_MAKE_NAME)
        return Note(inputService.getString())
    }
}