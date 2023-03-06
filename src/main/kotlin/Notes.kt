
fun viewNotesMenu(): MutableMap<Int, String> {
    val choiceMap: MutableMap<Int, String> = mutableMapOf(
        0 to "Вернуться",
        1 to "Создать заметку",
    )

    // сначала написала через put()
    // но IDE подсказала, что надо конвертировать в такой вид, как у массивов
    choiceMap[2] = "Моя заметка"
    choiceMap[3] = "Моя вторая заметка"


    // выводим список на экран
    println("Список заметок в архиве:")
    choiceMap.forEach { (key, value) -> println("$key. $value") }

    println()
    println("Выберете пункт и напечатайте цифру, указанную рядом с пунктом.")
    println("Что будем делать? ")

    return choiceMap
}
fun checkNotesAnswer(number: Int): Screen {
    return when(number) {
        0 -> Screen.ARCHIVES
        1 -> Screen.CREATE_NOTE
        else -> Screen.VIEW_NOTE
    }
}