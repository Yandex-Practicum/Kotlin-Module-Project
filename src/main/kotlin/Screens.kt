import java.util.Scanner

class Screens(private val archives: MutableList<Archive>) {
    private val scanner = Scanner(System.`in`)

    fun openArchiveMenu() {
        while (true) {
            val menu = MenuController("Список архивов:", "Выход")
            archives.forEach { archive ->
                menu.addItem(archive.name) { openNotesMenu(archive) }
            }

            println("\nСписок архивов:")
            println("0. Создать архив")
            menu.items.forEachIndexed { index, pair ->
                println("${index + 1}. ${pair.first}")
            }
            println("${menu.items.size + 1}. Выход")

            val input = scanner.nextLine().trim()
            val choice = input.toIntOrNull()

            if (choice == null) {
                println("Ошибка: следует вводить только цифры. Попробуйте снова.")
                continue
            }
            if (choice == menu.items.size + 1) {
                println("Программа завершена.")
                return
            }
            if (choice == 0) {
                val name = menu.readNonEmptyString("Введите название архива:")
                archives.add(Archive(name))
                println("Архив '$name' успешно создан!")
            } else if (choice > 0 && choice <= menu.items.size) {
                menu.items[choice - 1].second.invoke()
            } else {
                println("Ошибка: такой цифры нет в меню. Введите корректный символ.")
            }
        }
    }


    private fun openNotesMenu(archive: Archive) {
        while (true) {
            val menu = MenuController("Список заметок в архиве [${archive.name}]:", "Назад")
            archive.notes.forEach { note ->
                menu.addItem(note.title) { openNoteContentScreen(note) }
            }

            println("\nСписок заметок в архиве [${archive.name}]:")
            println("0. Создать заметку")
            menu.items.forEachIndexed { index, pair ->
                println("${index + 1}. ${pair.first}")
            }
            println("${menu.items.size + 1}. Назад")

            val input = scanner.nextLine().trim()
            val choice = input.toIntOrNull()

            if (choice == null) {
                println("Ошибка: следует вводить только цифры. Попробуйте снова.")
                continue
            }
            if (choice == menu.items.size + 1) return

            if (choice == 0) {
                val title = menu.readNonEmptyString("Введите название заметки:")
                val text = menu.readNonEmptyString("Введите текст заметки:")
                archive.notes.add(Note(title, text))
                println("Заметка '$title' успешно создана!")
            } else if (choice > 0 && choice <= menu.items.size) {
                menu.items[choice - 1].second.invoke()
            } else {
                println("Ошибка: такой цифры нет в меню. Введите корректный символ.")
            }
        }
    }


    private fun openNoteContentScreen(note: Note) {
        while (true) {
            println("\n=== Заметка: ${note.title} ===")
            println(note.text)
            println("=============================")
            println("0. Назад")

            val input = scanner.nextLine().trim()
            if (input == "0") return
            else println("Ошибка: для возврата введите цифру 0.")
        }
    }
}
