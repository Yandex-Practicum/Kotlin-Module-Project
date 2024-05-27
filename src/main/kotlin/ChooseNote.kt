fun chooseNote(entry: Int){

    val funMenu = {println("0 - Возврат в меню выбора архива")
        println("1 - Создать заметку")

        if (NotePad.getArchive(entry).sizeArchive() > 0) {
            for (i in 0..NotePad.getArchive(entry).sizeArchive()-1) {
                println("${i + 2} - Просмотр заметки ${NotePad.getArchive(entry).getNote(i).name}")
            }
        }
    }
    println()
    println("******************")
    println("Содержимое архива ${NotePad.getArchive(entry).name}")
    val iMenu = createMenu(funMenu)

    when (iMenu){
        0 -> chooseArchive()
        1 -> {
            println()
            println("******************")
            println("Создание заметки")
            val nameNote = getText("Имя")
            val textNote = getText("Содержимое")
            val note = Note(nameNote,textNote)
            NotePad.getArchive(entry).addNote(note)
            startScreen(Screen.CHOOSE_NOTE, entry)
        }
        in 2..NotePad.getArchive(entry).sizeArchive()+1 ->{
            println("# Заметка ${NotePad.getArchive(entry).getNote(iMenu-2).name}:")
            println("# ${NotePad.getArchive(entry).getNote(iMenu-2).note}")
            println()
            anyKey()
            startScreen(Screen.CHOOSE_NOTE, entry)
        }
        else -> {
            printMenuError()
            startScreen(Screen.CHOOSE_NOTE, entry)

        }


    }
}

