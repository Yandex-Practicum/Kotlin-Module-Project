import java.util.Scanner

class Archive(val name: String) {
    private val check1 = Check()
    private val scanner3 = Scanner(System.`in`)// очень много сканнеров...
    private val scanner4 = Scanner(System.`in`)
    private val scanner5 = Scanner(System.`in`)


    private val notes = mutableListOf<Note>()
    private fun createNote() {
        println("Введите название заметки!")
        val nameOfNote = scanner5.nextLine()
        println("Введите текст заметки")
        val textOfNote = scanner5.nextLine()
        notes.add(Note(nameOfNote, textOfNote))
        println("Заметка с имененем $nameOfNote создана")
    }

    fun showNotesMenu(scanner: Scanner) {
        while (true) {
            println("Выберите следующее действие:")
            println("1 - Посмотреть заметки")
            println("2 - Создать заметку")
            println("0 - Выход ")
            if (scanner3.hasNextInt()) {
                val input3 = scanner.nextInt()
                when (input3) {
                    1 -> {
                        if (notes.isEmpty()) {
                            println("К сожалению, заметки отсутствуют! создайте новые!")
                            return
                        } else {
                            notes.forEachIndexed { index, note -> println("${index + 1}. ${note.name}") }
                            println("Выберите заметку по номеру!")
                            if (scanner4.hasNextInt()) {
                                val input4 = scanner.nextInt()
                                when (input4) {
                                    in 1..notes.size -> {
                                        notes[input4 - 1].showNote()
                                    }
                                    else -> {
                                        check1.errorOfScanner()
                                    }
                                }
                            } else {
                                check1.errorOfScanner()
                                return
                            }
                        }
                    }
                    2 -> {
                        createNote()
                    }
                    0 -> {
                        return
                    }
                    else -> {
                        check1.errorOfScanner()
                    }

                }
            } else {
                check1.errorOfScanner()
                return
            }


        }

    }
}