import java.util.Scanner
class LogicApp(val title: String) {
    val archives = mutableListOf<Archive>()

    fun showMenu(menuName: String, archive: Archive? = null) {
        println(title)
        println("0. Создать $menuName")
        println("1. Открыть $menuName")
        println("2. Выход")
        val scanner = Scanner(System.`in`)
        if (scanner.hasNextInt()) {
            val num = scanner.nextInt()
            when(num) {
                0 -> {
                    if (menuName == "архив") addArchive()
                    if (menuName == "заметку") addNoteToArchive(archive!!)
                    showMenu(menuName, archive)
                }
                1 -> {
                    if (menuName == "архив") showArchives()
                    if (menuName == "заметку") showArchiveNotes(archive!!)
                }
                2 -> {
                    exit()
                }
                else -> {
                    println("Некорректный выбор. Пожалуйста, выберите пункт меню от 0 до 2.")
                    showMenu(menuName, archive)
                }
            }
        } else {
            println("Некорректный ввод. Пожалуйста, введите цифру.")
            showMenu(menuName, archive)
        }
    }

    fun addArchive() {
        println("Введите название архива:")
        val name = Scanner(System.`in`).nextLine()
        val archive = Archive(name)
        archives.add(archive)
        println("Архив '$name' успешно создан")
        showMenu("архив", archive)
    }

    fun showArchives() {
        println("Список архивов:")
        archives.forEachIndexed { index, archive ->
            println("${index + 1}. ${archive.name}")
        }
        println("Введите номер архива, чтобы открыть:")
        val scanner = Scanner(System.`in`)
        if (scanner.hasNextInt()) {
            val num = scanner.nextInt()
            if (num in 1..archives.size) {
                val archive = archives[num - 1]
                showMenu("заметку", archive)
            } else {
                println("Некорректный выбор. Пожалуйста, выберите номер от 1 до ${archives.size}.")
                showArchives()
            }
        } else {
            println("Некорректный ввод. Пожалуйста, введите номер архива.")
            showArchives()
        }
    }

    fun showArchiveNotes(archive: Archive) {
        println("Заметки из архива '${archive.name}':")
        if (archive.notes.isEmpty()) {
            println("Заметки в '${archive.name}' не найдены")
            showArchives()
        } else {
            archive.notes.forEachIndexed { index, note ->
                println("Заметка № ${index + 1}.")
            }
            println("Введите номер заметки, чтобы прочитать текст:")
            val scanner = Scanner(System.`in`)
            if (scanner.hasNextInt()) {
                val num = scanner.nextInt()
                if (num in 1..archive.notes.size) {
                    val archive = archive.notes[num - 1]
                    println("Текст заметки: '${archive.text}'")
                    showArchives()
                } else {
                    println("Некорректный выбор. Пожалуйста, выберите номер от 1 до ${archive.notes.size}.")

                }
            } else {
                println("Некорректный ввод. Пожалуйста, введите номер архива.")
                showArchives()
            }
        }
    }

    fun addNoteToArchive(archive: Archive) {
        println("Введите текст заметки:")
        val text = Scanner(System.`in`).nextLine()
        val note = Note(text)
        archive.notes.add(note)
        println("Заметка успешно добавлена в архив '${archive.name}'")
        showMenu("заметку", archive)
    }

    fun exit() {
    }
}
