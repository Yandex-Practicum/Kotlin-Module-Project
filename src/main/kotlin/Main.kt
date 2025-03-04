import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    val archives = mutableListOf<Archive>()

    fun showNotesMenu(archive: Archive) {
        var shouldShowMenu = true
        while (shouldShowMenu) {
            val items = mutableListOf<Pair<String, () -> Boolean>>().apply {
                add("Создать заметку" to {
                    print("Введите название заметки: ")
                    val title = scanner.nextLine().trim()
                    if (title.isEmpty()) {
                        println("❌ Название заметки не может быть пустым!")
                        return@to true
                    }

                    print("Введите содержание заметки: ")
                    val content = scanner.nextLine().trim()
                    if (content.isEmpty()) {
                        println("❌ Содержание не может быть пустым!")
                        return@to true
                    }

                    archive.notes.add(Note(title, content))
                    println("✅ Заметка '$title' добавлена")
                    false
                })

                archive.notes.forEach { note ->
                    add(note.title to {
                        println("\n📝 ${note.title}")
                        println(note.content)
                        println("\n↵ Нажмите Enter чтобы вернуться...")
                        scanner.nextLine()
                        true
                    })
                }
            }

            shouldShowMenu = Menu(
                title = "📂 Архив: ${archive.name}",
                items = items
            ).show(exitText = "Назад")
        }
    }

    fun showArchivesMenu() {
        while (true) {
            val items = mutableListOf<Pair<String, () -> Boolean>>().apply {
                add("Создать архив" to {
                    print("Введите название архива: ")
                    val name = scanner.nextLine().trim()
                    if (name.isEmpty()) {
                        println("❌ Название архива не может быть пустым!")
                        return@to true
                    }
                    archives.add(Archive(name))
                    println("✅ Архив '$name' создан")
                    false
                })

                archives.forEach { archive ->
                    add(archive.name to {
                        showNotesMenu(archive)
                        true
                    })
                }
            }

            Menu(
                title = "🗄️ Главное меню",
                items = items
            ).show(exitText = "Выход из программы")
        }
    }

    showArchivesMenu()
}