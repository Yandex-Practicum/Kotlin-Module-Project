fun main() {

    val archives : MutableMap<String, Archive> = mutableMapOf()
    var archive : Archive
    var notes : MutableMap<String, Note>
    var note : Note
    val menuArchive = Menu<Archive>("Создание и выбор архивов","архив", "нового архива")
    val menuNote = Menu<Note>("Создание и выбор заметок","заметку", "новой заметки")

    println("Консольное приложение для заметок")
    while(true) {
        when (menuArchive.select(archives)) {
            0 -> {      // Создать архив
                if (archives.containsKey(menuArchive.itemName))
                    println("Архив '${menuArchive.itemName}' уже существует, не могу создать еще один архив с таким именем")
                else {
                    archives.put(menuArchive.itemName, Archive(menuArchive.itemName))
                    println("Архив '${menuArchive.itemName}' добавлен")
                }
            }
            1 -> {      //  Выбрать архив
                if (archives.containsKey(menuArchive.itemName)) {
                    archive = archives.get(menuArchive.itemName)!!
                    println("Архив '${archive.title}' выбран")
                    notes = archive.notes
                    while(true) {
                        when (menuNote.select(notes)) {
                            0 -> {  // Создать заметку
                                if (notes.containsKey(menuNote.itemName))
                                    println("В архиве ${archive.title} уже существует заметка '${menuNote.itemName}', не могу создать еще одну заметку с таким именем")
                                else {
                                    notes.put(menuNote.itemName, Note(menuNote.itemName))
                                    println("Заметка '${menuNote.itemName}' добавлена в архив ${archive.title}")
                                }
                            }
                            1 -> {  // Выбрать заметку
                                if (notes.containsKey(menuNote.itemName)) {
                                    note = notes.get(menuNote.itemName)!!
                                    println("Заметка '${note.title}' из архива '${archive.title}' выбрана")
                                    if (note.text.isEmpty()) {
                                        println("Заметка '${note.title}' из архива '${archive.title} пустая")
                                        note.inputText()                            // Добавление текста заметки
                                    }
                                    if (!note.text.isEmpty()) {                      // Просмотр заметки (в т.ч. сразу после ввода)
                                        println("НАЗВАНИЕ АРХИВА: ${archive.title}")
                                        println("НАЗВАНИЕ ЗАМЕТКИ: ${note.title} ")
                                        println("ТЕКСТ ЗАМЕТКИ:")
                                        for (line in note.text) {
                                            println(line)
                                        }
                                    }
                                }
                                else
                                    println("Заметки '${menuNote.itemName}' в архиве '${archive.title}' не существует, не могу выбрать заметку с таким именем")

                            }
                            2 -> break
                        }
                    }
                }
                else
                    println("Архива '${menuArchive.itemName}' не существует, не могу выбрать архив с таким именем")
            }
            2 -> break      // Выход
        }
    }
    println("Окончание работы консольного приложения для заметок")
}

