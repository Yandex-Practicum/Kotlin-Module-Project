import java.util.Scanner

class Archives {
    private val archives = Items()
    private val notes = Notes()

    fun printListArchives() {
        while (true) {
            val archiveList = archives.getItems()
            if (archiveList.isEmpty()) {
                println("Список пуст. Архивы еще не добавлены")
                return
            } else {
                println("Список архивов:")
                for ((index, archive) in archiveList.withIndex()) {
                    println("${index + 1}. ${archive.itemName}")
                }
            }

            val readScanner = getUserInput("Введите номер архива для перехода или 0 для возврата в главное меню:")
            if (readScanner == "0") {
                break
            } else {
                val archiveIndex = readScanner.toIntOrNull()
                if (archiveIndex != null && archiveIndex in 1..archiveList.size) {
                    manageArchive(archiveIndex - 1)
                } else {
                    println("Вы ввели неверную команду, попробуйте снова")
                }
            }
        }
    }

    fun createArchive() {
        while (true) {
            val archiveName = getUserInput("Введите название архива:")
            if (archiveName.isNotEmpty()) {
                val newArchive = Item(archiveName)
                archives.addItemToList(newArchive)
                println("Архив ${newArchive.itemName} создан!")
                break
            } else {
                println("Название архива не может быть пустым")
            }
        }
    }

    private fun manageArchive(index: Int) {
        val archive = archives.getItemIndex(index)
        if (archive != null) {
            while (true) {
                println("Архив: ${archive.itemName}\n1. Список заметок\n2. Создать заметку\n3. Вернуться к списку архивов")
                when (getUserInput("Введите команду:")) {
                    "1" -> notes.printNotesList(archive)
                    "2" -> notes.createNoteForArchive(archive)
                    "3" -> break
                    else -> println("Вы ввели неверную команду, попробуйте снова")
                }
            }
        } else {
            println("Архив не найден.")
        }
    }

    private fun getUserInput(prompt: String): String {
        println(prompt)
        return Scanner(System.`in`).nextLine().trim()
    }
}
