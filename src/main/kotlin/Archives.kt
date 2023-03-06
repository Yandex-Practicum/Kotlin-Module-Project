
fun viewArchiveMenu(archiveList: MutableList<Archive>): MutableMap<Int, String> {
    // хотела сначала выбрать обычный список,
    // но решила поупражняться с Map
    val choiceMap: MutableMap<Int, String> = mutableMapOf(
        0 to "Выход",
        1 to "Создать архив",
    )

    var key = 2;
    for (archive in archiveList) {
        choiceMap[key] = archive.name
        key++
    }

    // выводим список на экран
    println("Список архивов:")
    choiceMap.forEach { (key, value) -> println("$key. $value") }

    println()
    println("Выберете пункт и напечатайте цифру, указанную рядом с пунктом.")
    println("Что будем делать? ")

    return choiceMap
}

fun checkArchiveAnswer(number: Int): Screen {
    return when(number) {
        0 -> Screen.EXIT
        1 -> Screen.CREATE_ARCHIVE
        else -> {
            Screen.NOTES
        }
    }
}