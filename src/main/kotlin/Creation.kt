import Archive.Companion.archives
import Input.Companion.scanner

class Creation {
    companion object {
        val menu: Menu = Menu()
        var archiveNumber: Int? = null

        fun createArchive(): Archive {
            println("введите название нового архива")
            val name = scanner.nextLine()
            println("архив $name успешно создан")
            return Archive(name)
        }

        fun chooseArchive() {
            if (archives.isNotEmpty()) {
                println("выберите архив или назад")
                for (archive in archives) {
                    println("${archives.indexOf(archive)}. ${archive.title}")
                }


                val input = scanner.nextLine()

                if (Input.checkInt(input)) {
                    archiveNumber = input.toInt()
                    if (input.toInt() >= 0 && input.toInt() <= archives.size) {
                        menu.noteMenuPrint()
                    }
                }
            } else {
                println("Нет созданных архивов")
            }
        }

        fun createNote() {
            println("Создание заметки, введите название")
            val title = scanner.nextLine()
            println("Введите текст заметки")
            val text = scanner.nextLine()
            val note = Note(title, text)
            putNoteToArchive(note)
            println("Заметка $title успешно создана и добавлена в архив ${archives[archiveNumber!!].title}")
            menu.noteMenuPrint()
        }

        fun putNoteToArchive(note: Note) {
            archives[archiveNumber!!].notes.add(note)
        }

        fun chooseNote() {
            if (archives[archiveNumber!!].notes.isNotEmpty()) {
                println("выберите заметку или назад")
                for (note in archives[archiveNumber!!].notes) {
                    println("${archives[archiveNumber!!].notes.indexOf(note)}. ${note.title}")

                }
                println("${archives[archiveNumber!!].notes.size}. назад")

                val input = scanner.nextLine()
                if (Input.checkInt(input)) {
                    if (input.toInt() == archives[archiveNumber!!].notes.size) {
                        menu.noteMenuPrint()
                    } else if (input.toInt() >= 0 && input.toInt() <= archives[archiveNumber!!].notes.size) {
                        openNote(archives[archiveNumber!!].notes[input.toInt()])
                    } else {
                        println("такой заметки не существует")
                        menu.noteMenuPrint()
                    }

                }
            } else {
                println("список заметок пустой")
                menu.noteMenuPrint()
            }
        }

        fun openNote(note: Note){
            println(note.text)
            chooseNote()
        }
    }
}