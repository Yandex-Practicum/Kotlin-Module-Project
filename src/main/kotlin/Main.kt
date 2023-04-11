fun main() {
    val archive = ArchiveFunctions()
    println("Программа для работы с заметками успешно запущена")
    println("В архиве отсутствуют записи\nвведите номер строки в меню:")
    while (true) {
        println("1. Создать архив\n2. Список архивов\n0. Выход")

        when (InputKey().inputInt(2)) {
            0 -> break
            1 -> {
                println("Введите имя архива:")
                archive.archiveList.add(Archive(InputKey().inputStr(), mutableListOf()))
            }

            2 -> {
                println("Архивы:")
                archive.archiveList.forEachIndexed { index, element ->
                    println("${index}. ${element.name}")
                }
                println("${archive.archiveList.size}. назад")
                when (val input = InputKey().inputInt((archive.archiveList.size))) {
                    (archive.archiveList.size) -> continue
                    else -> {
                        val notesArch = archive.archiveList[input]
                        while (true) {
                            println("Заметки в архиве ${notesArch.name}")
                            notesArch.notesList.forEachIndexed { index, element ->
                                println("${index}. ${element.name}")
                            }
                            println("Введите номер заметки или")
                            println(
                                "${notesArch.notesList.size}. для создания заметки или \n" +
                                        "${notesArch.notesList.size + 1}. перейти назад"
                            )

                            when (val inp = InputKey().inputInt((notesArch.notesList.size + 1))) {
                                (notesArch.notesList.size) -> {
                                    println("Введите имя заметки:")
                                    val name = InputKey().inputStr()
                                    println("Введите текст заметки:")
                                    val content = InputKey().inputStr()
                                    notesArch.notesList.add(Note(name, content))
                                }

                                (notesArch.notesList.size + 1) -> break
                                else -> {
                                    val note = notesArch.notesList[inp]
                                    println("заметка ${note.name}\n${note.noteContent}")
                                    println("0. перейти назад")
                                    when(InputKey().inputInt(0)){
                                        0 -> continue
                                    }
                                }
                            }


                        }


                    }

                }
            }
        }
    }
}