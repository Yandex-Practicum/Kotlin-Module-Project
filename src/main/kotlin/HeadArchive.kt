data class HeadArchive(var headArchive: MutableList<Archive>) {


    fun showAllArchives() = if (headArchive.isNotEmpty()) {
        println("Список архивов:")
        for (i in headArchive.indices) {
            println("=====\n$i. Название:${headArchive.get(i).name}")
        }
    } else println("Архивов нет")
}