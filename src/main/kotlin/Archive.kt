data class Archive (
    val archiveName: String,
    val archiveList: MutableList<Note>
) {
    constructor() : this("", mutableListOf())

    fun createArchive(): Archive {
        println("Введите название нового архива:")
        val newArchive = Archive(UserInput().textInput(), mutableListOf())
        allArchivesList.add(newArchive)
        println("Архив под именем \"${newArchive.archiveName}\" успешно добавлен!")
        return newArchive
    }

    fun allArchives() {
            for (i in allArchivesList.indices) {
                println("Архив номер : ${i+1} \nНазвание : ${allArchivesList[i].archiveName} \nКоличество заметок : ${allArchivesList[i].archiveList.size} \n-----------------------")
            }

    }
}
