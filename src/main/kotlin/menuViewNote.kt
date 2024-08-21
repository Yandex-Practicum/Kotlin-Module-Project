fun menuViewNote(note: Note){
    val menu = mutableListOf<Pair<String,(Int) -> Unit>>()
    menu.add(Pair("Добавить текст заметки", {addNoteText(note); menuViewNote(note)}))
    menu.add(Pair("Показать текст заметки", {println(note.text)}))
    menu.add(Pair("Выход", {}))
    UserMenu().start("", menu)
}