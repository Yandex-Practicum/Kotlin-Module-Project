import java.util.Scanner

class AppArhiveNote {
    val scanner = Scanner(System.`in`)
    val archives: MutableList<Archive> = mutableListOf()


    fun createArchive() {
        println("Введите название Архива")
        val userEnter = scanner.next()
        while (true) {
            if (userEnter.isEmpty()) {
                println("Вы не можете создать архив без заголовка")
                return
            } else {
                break
            }
        }

        val notes = mutableListOf<Note>()
        archives.add(Archive(userEnter, notes))
        println("Архив создан")
        return

    }

    fun showArchives(): Unit? {

        if (archives.isEmpty()) {
            println("\nСписок архивов пуст.")

            return null
        } else {
            println("\nСписок архивов:")
            for ((index, archive) in archives.withIndex()) {
                println("${index + 1}. ${archive.name}")

            }
        }
        return println("")
    }

    fun selectArchive(): Archive {
        println("Выберите номер архива")

        while (true) {
            if (scanner.hasNextInt()) {
                val choice = scanner.nextInt()
                return archives[choice - 1]
            } else {
                println("Введите номер архива который хотите выбрать 1 до ${archives.size + 1}")
                scanner.next()
            }
        }

    }

    fun createNoteInArchive(archive: Archive) {

        println("Введите название заметки:")
        val titleNote = Scanner(System.`in`).nextLine()
        while (true) {
            if (titleNote.isEmpty()) {
                println("Вы не можете создать заметку без заголовка или пустую заметку")
                return
            } else {
                break
            }
        }
        println("Ввведите текст заметки:")
        val textNote = Scanner(System.`in`).nextLine()
        while (true) {
            if (textNote.isEmpty()) {
                println("Вы не можете создать заметку без заголовка или пустую заметку")
                return
            } else {
                break
            }
        }
        archive.arhivsList.add(Note(titleNote, textNote))
        println("Заметка создана")
        return
    }


    fun showNotesInArchive(archive: Archive): Note {
        println("Выберите номер заметки")
        val inde = archives.indexOfFirst { it.name == archive.toString() }

        while (true) {

            if (scanner.hasNextInt()) {
                val choice = scanner.nextInt()
                return archives[inde].arhivsList[choice - 1]
            } else {
                println("Введите номер заметки который хотите выбрать 1 до ${archives[inde].arhivsList.size + 1}")
                scanner.next()
            }
        }
    }


    fun selectNoteInArchive(archive: Archive): Unit? {
        val inde = archives.indexOfFirst { it.name == archive.toString() }

        if (archives[inde].arhivsList.isEmpty()) {
            println("\nСписок заметок пуст.")
            return null
        } else {
            println("\nСписок заметок:")
            for ((index) in archives[inde].arhivsList.withIndex()) {
                println("${index + 1}. ${archives[inde].arhivsList[index]}")

            }
        }
        return println("")
    }

    fun showNoteDetails(notes: Note) {
        println("Заметка")
        println("Название:\n ${notes.name}")
        println("Текст:\n ${notes.notesList}")
        println("Введите любой символ для выхода в Меню заметок")
        scanner.next()
    }

}

