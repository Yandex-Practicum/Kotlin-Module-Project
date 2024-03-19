package ui.console.exceptions

class ArchiveNotFountException(archiveIdx: Int): Exception("Архив с номером $archiveIdx  не найден")