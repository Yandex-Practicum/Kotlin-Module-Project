fun menuSelectNote(archive: Archive){
    val menu = mutableListOf<Pair<String,(Int) -> Unit>>()
    menu.add(Pair("Создать заметку", {archive.notes.add(menuCreateNote()); menuSelectNote(archive)}))
    for (note in archive.notes) menu.add(Pair(note.name, {menuViewNote(note)}))
    menu.add(Pair("Выход", {}))
    UserMenu().start("", menu)
}