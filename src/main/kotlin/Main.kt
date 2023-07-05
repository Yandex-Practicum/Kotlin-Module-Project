fun main() {
    val appNotes = FunctionsAppNotes()
    while (true) {
        println("1. Создать архив")
        println("2. Список архивов")
        println("3. Выход")

        when (try {
            readln().toInt()
        } catch (e: Exception) {
        }) {

            1 -> {
                println("Введите название архива:")
                val nameArch = readln()
                appNotes.addArchive(nameArch)
            }

            2 -> {
                while (true) {
                    println("Список архивов:")
                    val archives = appNotes.getArсhives()
                    for (i in archives.indices) {
                        println("$i. ${archives[i]}")
                    }
                    println("${archives.size}. Назад")

                    val archiveChoice: Int = try {
                        readln().toInt()
                    } catch (e: Exception) {
                        archives.size + 2
                    }

                    when {
                        archiveChoice < archives.size -> {
                            val archiveName = archives[archiveChoice]
                            while (true) {
                                println("Список заметок в архиве: $archiveName")
                                val notes = appNotes.getNote(archiveChoice)
                                for (i in notes.indices) {
                                    println("$i. ${notes[i]}")
                                }
                                println("${notes.size}. Создать заметку")
                                println("${notes.size + 1}. Назад")


                                val noteChoice: Int = try {
                                    readln().toInt()
                                } catch (e: Exception) {
                                    archives.size + 2
                                }

                                when {
                                    noteChoice == notes.size -> {
                                        println("Введите название заметки:")
                                        val nameNote = readln()
                                        println("Введите текст заметки:")
                                        val textNote = readln()
                                        appNotes.addNoteToArchive(archiveChoice, nameNote, textNote)
                                    }

                                    noteChoice == notes.size + 1 -> {
                                        break
                                    }

                                    noteChoice < notes.size -> {
                                        val nameNote = notes[noteChoice]
                                        val textNote =
                                            appNotes.getTextNote(archiveChoice, noteChoice)
                                        println("Заметка '$nameNote'. Текс заметки: $textNote")
                                    }

                                    else -> println("Неверный выбор")
                                }
                            }
                        }

                        archiveChoice == archives.size -> {
                            break
                        }

                        else -> println("Неверный выбор")

                    }
                }
            }

            3 -> break

            else -> println("Неверный выбора")

        }
    }
}