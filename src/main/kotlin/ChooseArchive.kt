fun chooseArchive(){
    val funMenu = {println("0 - Выход")
        println("1 - Создать архив")
        if (NotePad.sizeNotePad() > 0) {
            for (i in 0..NotePad.sizeNotePad()-1) {
                println("${i + 2} - Просмотр архива ${NotePad.getArchive(i).name}")
            }
        }
    }
    val iMenu = createMenu(funMenu)

    when (iMenu){
        0 -> startScreen(Screen.EXIT, 0)
        1 -> {
            println()
            println("******************")
            println("Создание архива")
            NotePad.addArchive(getText("Имя"))
            startScreen(Screen.CHOOSE_ARCHIVE, 0)
        }
        in 2..NotePad.sizeNotePad()+1 ->{
            chooseNote(iMenu-2)
        }
        else -> {
            printMenuError()
            startScreen(Screen.CHOOSE_ARCHIVE, 0)
        }
    }

}