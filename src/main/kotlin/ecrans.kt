import java.util.Scanner

class Ecrans {
    private val scanner = Scanner(System.`in`)
    private val archives = mutableListOf<Archive>()
    fun showArchivesScreen() {
        var isRunning = true
        while(isRunning) {
            val archiveMenuItems = mutableListOf<MenuItem>()
            archiveMenuItems.add(MenuItem("создать архив") { createArchive() })
            archives.forEach { archive ->
                archiveMenuItems.add(MenuItem(archive.name) { showZametkiScreen(archive) })
            }
            archiveMenuItems.add(MenuItem("выход") { isRunning = false })
            Menu("список архивов", archiveMenuItems).show()
        }
    }
    private fun createArchive() {
        while(true) {
            print("введите название архива: ")
            val archiveName = scanner.nextLine().trim()
            if(archiveName.isEmpty()) {
                println("название архива не может быть пустым")
                continue
            }
            archives.add(Archive(archiveName))
            println("Архив " + archiveName + " создан")
            break
        }
    }

    fun showZametkiScreen(archive: Archive) {
        var isInsideArchive = true
        while(isInsideArchive) {
            val zametkiMenuItems = mutableListOf<MenuItem>()
            zametkiMenuItems.add(MenuItem("создать заметку") { createZametka(archive) })
            archive.zametki.forEach { zametka ->
                zametkiMenuItems.add(MenuItem(zametka.title) { viewZametkaScreen(zametka) })
            }
            zametkiMenuItems.add(MenuItem("назад") { isInsideArchive = false })
            Menu("архив " + archive.name + " -> список заметок", zametkiMenuItems).show()
        }
    }
    private fun createZametka(archive: Archive) {
        while(true) {
            print("введите название заметки: ")
            val zametkaTitle = scanner.nextLine().trim()
            if (zametkaTitle.isEmpty()) {
                println("название заметки не может быть пустой")
                continue
            }
            print("введите текст заметки: ")
            val zametkaText = scanner.nextLine().trim()
            if (zametkaText.isEmpty()) {
                println("заметка не может быть пустой")
                continue
            }
            archive.zametki.add(Zametka(zametkaTitle, zametkaText))
            println("заметка " + zametkaTitle + " создана")
            break
        }
    }
    private fun viewZametkaScreen(zametka: Zametka) {
        val viewMenuItems = listOf(
            MenuItem("назад") { }
        )
        println("Название: " + zametka.title)
        println("Текст: " + zametka.text)
        Menu("действия с заметкой", viewMenuItems).show()
    }
}