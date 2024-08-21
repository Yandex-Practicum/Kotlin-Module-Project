fun menuSelectArchives(archives: MutableList<Archive>){
    val menu = mutableListOf<Pair<String,(Int) -> Unit>>()
    menu.add(Pair("Создать архив", {archives.add(menuCreateArchive()); menuSelectArchives(archives)}))
    for (archive in archives) menu.add(Pair(archive.name, {menuSelectNote(archive)}))
    menu.add(Pair("Выход", {}))
    UserMenu().start("", menu)
}

