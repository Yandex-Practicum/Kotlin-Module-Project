
import java.util.Scanner

class MainMenu(private val archiveManager: ArchiveManager, private val scanner: Scanner) {
    fun show() {
        while (true
        ) {
            println("\n=== Главное меню ===")
            println("1. Создать новый архив")
            println("2. Просмотреть архивы")
            println("3. Управление архивом")
            println("4. Выйти из программы")

            print("Выберите действие: ")
            val choice = scanner.nextLine()

            when (choice) {
                "1" -> createArchive()
                "2" -> viewArchives()
                "3" -> archiveManagementMenu()
                "4" -> {
                    println("До свидания!")
                    return
                }
                else -> println("Неверное действие. Попробуйте снова.")
            }
        }
    }

    private fun createArchive() {
        print("Введите название архива: ")
        val name = scanner.nextLine()


        if (name.isNullOrEmpty()) {
            println("Ошибка: Имя не может быть пустым.")
            return
        }


        if (name in archiveManager.getArchiveNames()) {
            println("Такой архив уже существует.")
            return
        }


        if (archiveManager.createArchive(name)) {
            println("Архив создан успешно.")
        } else {

            println("Произошла ошибка при создании архива.")
        }
    }

    private fun viewArchives() {
        val archives = archiveManager.getArchiveNames()
        if (archives.isNotEmpty()) {
            println("Список архивов:")
            archives.forEach { println(it) }
        } else {
            println("Архивы не найдены.")
        }
    }

    private fun archiveManagementMenu() {
        ArchiveManagementMenu(archiveManager, scanner).show()
    }
}