import kotlin.system.exitProcess

class ArchiveScreen(val archivesList: MutableList<DataArchive>) : Navigation(
    "Список архивов:",
    listOf(
        "Создать архив" to { ArchiveCreate().createArchive(archivesList) },
        "Выбрать архив" to { SelectArchive(archivesList).watch() },
        "Выход" to { exitProcess(0) }
    )
)//класс Archives и ArchiveScreen имеют общую логику, но написаны по-разному
