import data.Archives

fun main(args: Array<String>) {
    val archives = Archives("Список архивов")
    archives.content = mutableListOf()
    ArchivesScreen().show(archives)
}


