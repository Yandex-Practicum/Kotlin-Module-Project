import java.util.Scanner

class Archive : Menu {

    private val scanner = Scanner(System.`in`)
    private val archiveList : MutableList <ArchiveCreate> = mutableListOf()

    fun startArchive() {

        titlePrintMenu()

            while (true) {

                if (scanner.hasNextInt()) {

                    when (val commandMenuArchive = scanner.nextInt()) {

                        0 -> {
                            println("Введите имя архива:")
                            scanner.nextLine()

                            var scanNameArchives = scanner.nextLine()

                            while (scanNameArchives.trim().isEmpty()) {
                                println("Имя не пожет быть пустым. Повторите ввод:")
                                scanNameArchives = scanner.nextLine()
                            }

                            archiveList.add(ArchiveCreate(scanNameArchives))

                            titlePrintMenu()
                        }

                        archiveList.size + 1 -> {
                            println("Выход...")
                            return
                        }

                        in (archiveList.indices + archiveList.size) -> {

                            val note = Note(noteList = archiveList[commandMenuArchive-1].numberNoteList)
                            println("Архив: ${archiveList[commandMenuArchive-1].titleArchive}")

                            note.startNote()
                            titlePrintMenu()
                        }

                        else -> println("Такой цифры нет, повторите ввод")

                    }

                } else {
                    println("Вы ввели не число, попробуйте снова!")
                    scanner.next()
                }
            }
    }


    override fun titlePrintMenu() {
        println("""
            Список архивов:
            0. Создать архив                      
        """.trimIndent())

        archiveList.forEachIndexed { index, archiveCreate ->  println("${index + 1}. ${archiveCreate.titleArchive}")}
        println("${archiveList.size+1}. Выход")
    }
}
