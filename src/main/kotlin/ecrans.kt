import java.util.Scanner

class Ecrans {
    private val scanner = Scanner(System.`in`)
    private val archives = mutableListOf<Archive>()
    fun showArchivesScreen() {
        while(true) {
            val archiveMenuItems = mutableListOf<MenuItem>()
            archiveMenuItems.add(MenuItem("создать архив") { createArchive() })
            archives.forEach { archive ->
                archiveMenuItems.add(MenuItem(archive.name) { showZametkiScreen(archive) })
            }

            archiveMenuItems.add(MenuItem("выход") { })
            Menu("список архивов", archiveMenuItems).show()
            break
        }
    }
    private fun createArchive() {
        while(true) {
            print("ввелите название архива: ")
            val archiveName = scanner.nextLine().trim()
            if(archiveName.isEmpty()) {
                println("название архива не может быть пустым")
                continue
            }
            archives.add(Archive(archiveName))
            println("Архив " + archiveName + "создан")
            break
        }
    }
    private fun showZametkiScreen(archive: Archive) {
        val zametkiMenuItems = mutableListOf<MenuItem>()
        zametkiMenuItems.add(MenuItem("создать заметку") { createZametka(archive) })
        archive.zametki.forEach { zametka ->
            zametkiMenuItems.add(MenuItem(zametka.title) { viewZametkaScreen(zametka) })
        }
        zametkiMenuItems.add(MenuItem("назад") { })
        Menu("архив " + archive.name + " -> список заметок", zametkiMenuItems).show()
    }
    private fun createZametka(archive: Archive) {
        var zametkaTitle = ""
        while (zametkaTitle.isEmpty()) {
            print("введите название заметки: ")
            zametkaTitle = scanner.nextLine().trim()
            if (zametkaTitle.isEmpty()) {
                println("название заметки не может быть пустой")
            }
        }
        var zametkaText = ""
        while (zametkaText.isEmpty()) {
            print("введите текст заметки: ")
            zametkaText = scanner.nextLine().trim()
            if (zametkaText.isEmpty()) {
                println("заметка не может быть пустой")
            }
        }
        archive.zametki.add(Zametka(zametkaTitle, zametkaText))
        println("заметка" + zametkaTitle + " создана")
    }
    private fun viewZametkaScreen(zametka: Zametka) {
        val viewMenuItems = listOf(
            MenuItem("назад") { }
        )
        println("Название: " + zametka.title)
        println("Текст: " + zametka.text)
    }
}