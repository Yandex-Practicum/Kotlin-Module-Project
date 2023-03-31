import java.util.Scanner

class Archive(val name: String) : Tool() {
    private val scanner3 =
        Scanner(System.`in`)// очень много сканнеров... Могу их убрать, но будут провалы в цикле.
    private val scanner4 =
        Scanner(System.`in`)// он на следующей итерации думает, что нужно использовать то, что уже было введено до
    private val notes = mutableListOf<Note>()
    override val phrase1 = "заметки"
    override val phrase2 = "заметку"
    override var beforeInput: Int = 0

    override fun createOne() {
        println("Введите название заметки!")
        val nameOfNote = scanner4.nextLine()
        println("Введите текст заметки")
        val textOfNote = scanner4.nextLine()
        notes.add(Note(nameOfNote, textOfNote))
        println("Заметка с имененем $nameOfNote создана")
    }

    fun showList(scanner: Scanner) {
        while (true) {
            textOfMenu(phrase1, phrase2)
            check(beforeInput)
            val input3 = beforeInput
            when (input3) {
                1 -> {
                    chooseOne()
                }
                2 -> {
                    createOne()
                }
                0 -> {
                    return
                }
                else -> {
                    Error.errorOfScanner()
                }

            }
        }
    }

override fun chooseOne(){
    if (notes.isEmpty()) {
        println("К сожалению, $phrase1 отсутствуют! создайте новые!")
    } else {
        notes.forEachIndexed { index, note -> println("${index + 1}. ${note.name}") }
        println("Выберите $phrase2 по номеру!")
        check(beforeInput)
        val input4 = beforeInput
        when (input4) {
            in 1..notes.size -> {
                notes[input4 - 1].showList()
            }
            else -> {
                Error.errorOfScanner()
            }
        }
    }

}
}


