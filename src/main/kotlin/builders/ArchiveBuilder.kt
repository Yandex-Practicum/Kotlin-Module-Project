package builders

import Strings
import services.InputService
import models.Archive

class ArchiveBuilder(val inputService: InputService) {
    fun makeArchive(): Archive {
        println(Strings.ARCHIVE_MAKE_NAME)
        return Archive(inputService.getString())
    }
}