import java.util.Scanner

class Note
    (
    private val noteList: MutableList<NoteCreate>,
    ) : Menu {

    private val scan = Scanner(System.`in`)

        fun startNote() {

            titlePrintMenu()

            while (true) {

                if (scan.hasNextInt()) {

                    when (val commandMenuNote = scan.nextInt()) {

                        0 -> {
                            println("Введите имя заметки")
                            scan.nextLine()

                            var scanNameNote = scan.nextLine()

                                while (scanNameNote.trim().isEmpty()) {
                                    println("Имя заметки не пожет быть пустым. Повторите ввод:")
                                    scanNameNote = scan.nextLine()
                                }

                            println("Введите текст заметки")
                            var scanTextNote = scan.nextLine()

                                while (scanTextNote.trim().isEmpty()) {
                                    println("Текст заметки не пожет быть пустым. Повторите ввод:")
                                    scanTextNote = scan.nextLine()
                                }

                            noteList.add(NoteCreate(scanNameNote, scanTextNote))

                            titlePrintMenu()
                        }

                        noteList.size+1 -> {
                            println("Выход...")
                            println(" ")
                            break
                        }

                        in (noteList.indices + noteList.size) -> {
                            println("Заметка: ${noteList[commandMenuNote-1].titleNote}")
                            println(noteList[commandMenuNote-1].textNote)
                            titlePrintMenu()
                        }

                        else -> println("Такой цифры нет, повторите ввод")

                    }
                } else {
                    println("Вы ввели не число, попробуйте снова!")
                    scan.next()
                }
            }

        }


        override fun titlePrintMenu() {
            println(
                """                                                 
                            Список заметок:
                            0. Создать заметку
                        """.trimIndent()
            )
            noteList.forEachIndexed{ index, noteCreate -> println("${index + 1}. ${noteCreate.titleNote}")}
            println("${noteList.size+1}. Выход")
        }
}
