import java.util.*
/*
Для корректной работы программы необходимо выбирать команду/архив/заметку с помощью чисел.
Пример:
    Программа запущена
    Список архивов:
    0. Создать архив
    1. Выход

 Для создания архива необходимо нажать клавишу 0, а для выхода клавишу 1.
 Далее аналогичным образом.
 */

fun main() {

    while (true) {
        val notesApp: ArchivesBox = ArchivesBox()
        val warningsText: WarningsText = WarningsText()
        println("Программа запущена")
        while (true) {
            notesApp.showAllArchives()
            try {
                val archiveUserInput: Int = Scanner(System.`in`).nextInt()
                if (archiveUserInput==0) {
                    println("Введите название архива:")
                    while (true) {
                        val userArchive: Archive = Archive()
                        val archiveName: String = Scanner(System.`in`).nextLine()
                        if (userArchive.createArchive(archiveName)) {
                            notesApp.addArchive(userArchive)
                            break
                        }
                    }
                }
                else if (archiveUserInput==notesApp.getExitNum()) break
                else if (!notesApp.checkNum(archiveUserInput)) warningsText.notFoundNumber()
                else {
                    while (true) {
                        notesApp.showArchiveNotes(archiveUserInput)
                        val currentArchive: Archive? = notesApp.getArchive(archiveUserInput)
                        try {
                            val noteUserInput = Scanner(System.`in`).nextInt()
                            if (noteUserInput==0) {
                                while (true) {
                                    val userNote: Note = Note()
                                    println("Введите название заметки:")
                                    val noteName: String = Scanner(System.`in`).nextLine()
                                    println("Введите содержание заметки:")
                                    val noteContent: String = Scanner(System.`in`).nextLine()
                                    if (userNote.createNote(noteName, noteContent)) {
//                                        println(notesApp.getArchive(noteUserInput))
                                        currentArchive?.addNote(userNote)
                                        break
                                    }
                                }
                            }
                            else if (noteUserInput==currentArchive!!.getExitNum()) break
                            else if (!currentArchive.checkNum(noteUserInput)) warningsText.notFoundNumber()
                            else {
                                val currentNote: Note = currentArchive.getNote(noteUserInput)
                                currentNote.openNote()
                                while (true) {
                                    try {
                                        val contentUserInput = Scanner(System.`in`).nextInt()
                                        if (contentUserInput == 0) {
                                            println("Введите текст")
                                            currentNote.addContentToNote(Scanner(System.`in`).nextLine())
                                            break
                                        } else if (contentUserInput == currentNote.getExitNum()) break
                                        else if (!currentNote.checkNum(contentUserInput)) warningsText.notFoundNumber()
                                    }
                                    catch (e: InputMismatchException) {
                                        warningsText.notNumberInput()
                                    }
                                }
                            }
                        }
                        catch (e: InputMismatchException) {
                            warningsText.notNumberInput()
                        }
                    }
                }

            }
            catch (e: InputMismatchException) {
                warningsText.notNumberInput()
            }
        }
        println("Работа программы завершена")
        break
    }

}


