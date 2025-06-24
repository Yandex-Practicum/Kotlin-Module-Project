import java.util.Scanner

class NotesApp {
    var archives = mutableListOf<Archive>()
    var scanner = Scanner(System.`in`)

    fun start() {
        while (true) {
            println("1. Создать архив")
            println("2. Посмотреть архивы")
            println("3. Выход")
            when(scanner.nextLine().toIntOrNull()){
                1 -> createArchive()
                2 -> viewArchives()
                3 -> {scanner.close(); return}
                else -> println("Неверный ввод. Пожалуйста, введите число от 1 до 3!")
            }
        }
    }

    fun createArchive() {
        println("Придумайте название архива: ")
        val nameArchive = scanner.nextLine()
        if (nameArchive.isBlank()){
            println("Название архива не может быть пустым")
            return
        }
        archives.add(Archive(nameArchive))
        println("Архив $nameArchive создан!")
    }

    fun viewArchives() {
        if (archives.isEmpty()){
            println("Архив пуст ~~(;-;)~~")
            return
        }
        println("Список архивов")
        archives.forEachIndexed { index, archive -> println("${index + 1}. ${archive.name}") }
        println("0. Назад")
        val inx = scanner.nextLine().toIntOrNull()
        if (inx == null || (inx > archives.size)) { // Здесь надо поставить знак > вместо !in
            println("Неверный ввод. Пожалуйста, введите число от 0 до ${archives.size }.")
            return
        }
        if (inx == 0){
            return
        }
        viewArchive(archives[inx - 1])
    }

    fun viewArchive(archive: Archive) {
        while (true) {
            println("Выберите действие в архиве '${archive.name}':")
            println("1. Создать заметку")
            println("2. Открыть заметки")
            println("3. Назад")
            when (scanner.nextLine().toIntOrNull()) {
                1 -> createNote(archive)
                2 -> viewNotes(archive)
                3 -> return
                else -> println("Неверный ввод. Пожалуйста, введите число от 1 до 3.")
            }
        }
    }

    fun createNote(archive: Archive) {
        println("Введите текст: ")
        val textNote = scanner.nextLine()
        if (textNote.isBlank()){
            println("Название заметки не может быть пустым")
            return
        }
        archive.noteList.add(Note(textNote))
        println("Заметка создана!\nДля архива ${archive.name}")
    }

    fun viewNotes(archive: Archive) {
        if (archive.noteList.isEmpty()){
            println("Заметок нет ~~(;-;)~~")
            return
        }
        println("Список заметок: ")
        archive.noteList.forEachIndexed { index, note -> println("${index + 1}. ${note.text}") }
        println("0. Назад")
        val viewNoteIndex = scanner.nextLine().toIntOrNull()
        if(viewNoteIndex == null || (viewNoteIndex > archive.noteList.size)){  // Здесь надо поставить знак > вместо !in
            println("Неверный ввод. Пожалуйста, введите число от 0 до ${archive.noteList.size}.")
            return
        }
        if (viewNoteIndex == 0) {
            return
        }
        viewNote(archive.noteList[viewNoteIndex - 1])
    }

    fun viewNote(note: Note) {
        println(note.text)
    }

}