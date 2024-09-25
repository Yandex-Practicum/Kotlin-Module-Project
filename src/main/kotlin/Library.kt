import java.util.Scanner

class Library() {
    val name:String = "Хранилище"
    var archiveList = mutableListOf<Archive>()


    fun showContent() {
        if (archiveList.isNotEmpty()) {
            for (archive in archiveList) {
                println(archive.archiveName)
            }
        } else {
            println("Архивов нет. Создайте новый архив.")

        }
    }
    fun addArchive(archive: Archive){
        println("Введите название архива")
        archive.archiveName = getTextInput()
        archiveList.add(archive)
    }

    var listOfOptions: MutableList<String?> = mutableListOf("Создать архив", "Показать архивы")


}