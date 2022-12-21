fun main() {
    println("Привет! Начнем работу")
    moveMenu()
}

val archives = mutableListOf<Archive>()
val note = mutableListOf<Note>()


fun moveMenu() {
    while (true) {
        val textArchiveForMenu = listOf("архивов", "архив")
        val textNoteForMenu = listOf("заметок", "заметку")
        val textNoteEditMenu = listOf("заметке")
        val input = Menu()
        val param = input.inputUser(archives, textArchiveForMenu)
        when {
            param != 0 && param <= archives.size -> while (true) {
                val selectMenu = mutableListOf<Note>()
                for (i in note) {
                    if (i.id == archives[param - 1].name) {
                        selectMenu.add(i)
                    }
                }
                val select = input.inputUser(selectMenu, textNoteForMenu)
                if (select != 0 && select <= selectMenu.size) {
                    while (true) {
                        println("Заметка ${selectMenu[select - 1].name}")
                        val edit = input.inputUser(selectMenu, textNoteEditMenu)
                        when {
                            edit == 1 -> for (item in note) {
                                if (item == selectMenu[select - 1]) {
                                    input.editNote(item)
                                }
                            }

                            edit == 0 -> println("Заметка ${selectMenu[select - 1].name} содержит текст: ${selectMenu[select - 1].value}")

                        }
                        break
                    }
                } else if (select == 0) {
                    input.addNote(archives[param - 1].name)
                } else {
                    break
                }
            }

            param == 0 -> input.addArchive()
            else -> break


        }
    }
}

