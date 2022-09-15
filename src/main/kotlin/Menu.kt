class Menu {
    val arhiveMenuList = listOf(
        "Список архивов: ",
        "пуст",
        " ",
        "0. Создать новый архив",
        "1. Выбрать архив",
        "2. Выход"
    )
    val noteMenuList = listOf(
        "Список заметок: ",
        "пуст",
        " ",
        "0. Создать новую заметку",
        "1. Выбрать заметку",
        "2. к списку архивов"
    )
    fun listPrint(lstMenu:List<String>,listA:ArchiveList){
        when (lstMenu[0]) {
            "Список архивов: " -> {
                if(listA.archiveL.isNotEmpty()) {
                    for (arch in listA.archiveL) print("${arch.number} ")
                } else println(lstMenu[1])
            }
            "Список заметок: " -> if (listA.archiveL[listA.currentArchivehNumber].noteList.isNotEmpty()) {
                for (note in listA.archiveL[listA.currentArchivehNumber].noteList) print(
                    "${
                        listA.archiveL[listA.currentArchivehNumber].noteList.indexOf(
                            note
                        ) + 1
                    } "
                )
            } else println(lstMenu[1])

        }


    }

    fun universalMenu(lstMenu:List<String>,listA:ArchiveList){
        print(lstMenu[0])
        listPrint(lstMenu,listA)
        for(i in 2..lstMenu.size-1)
        println(lstMenu[i])

        inputAndCheck(lstMenu,listA,::archiveAction)
    }

    // Меню заметок
    fun noteMenu(lstMenu:List<String>,listA:ArchiveList) {
        val archN = listA.currentArchivehNumber
        print("Список заметок: ")
        if (listA.archiveL[archN].noteList.isNotEmpty()) {
            for (note in listA.archiveL[archN].noteList) print(
                "${
                    listA.archiveL[archN].noteList.indexOf(
                        note
                    ) + 1
                } "
            )
        } else println("пуст")
        println(" ")
        println("0. Создать новую заметку")
        println("1. Выбрать заметку")
        println("2. К списку архивов")
        val z = readln()
        if (isNumeric(z)) {
            val k = z.toInt()
            if(k in 0..2) noteAction(lstMenu,k, listA) else {
                println("Введите число от 0 до 2 !")
                noteMenu(lstMenu,listA)
            }
        } else {
            println("Введите число !!!")
            noteMenu(lstMenu,listA)
        }
    }

    fun noteAction(lstMenu:List<String>,choice: Int,listA: ArchiveList){
        when (choice) {
            0 -> createNote(lstMenu,listA)
            1 -> choiceNote(lstMenu,listA)
            2 -> universalMenu(lstMenu,listA)
        }
    }

    fun inputAndCheck(lstMenu:List<String>,listA:ArchiveList, actFun: (List<String>,Int,ArchiveList) -> Unit){
        var i = readln()
        if (isNumeric(i)) {
            var j = i.toInt()
            if(j in 0..2) actFun(lstMenu,j,listA) else {
                println("Введите число от 0 до 2 !")
                universalMenu(lstMenu, listA)
            }
        } else {
            println("Введите число !!!")
            universalMenu(lstMenu, listA)
        }
    }

    fun archiveAction(lstMenu:List<String>,choice: Int, listA: ArchiveList) {
        when (choice) {
            0 -> createArchive(lstMenu,listA)
            1 -> choiceArchive(lstMenu,listA)
            2 -> exitProg()
        }

    }

    fun createNote(lstMenu:List<String>, listA: ArchiveList) {
        println("Введите текст заметки")
        val txtNote = readln()
        listA.archiveL[listA.currentArchivehNumber].noteList.add(txtNote)
        println("Ваша заметка создана и добавлена в архив № ${listA.currentArchivehNumber+1}")
        noteMenu(lstMenu,listA)
    }

    fun choiceNote(lstMenu:List<String>,listA: ArchiveList) {
        print("Список заметок: ")
        if (listA.archiveL[listA.currentArchivehNumber].noteList.isNotEmpty()) {
            for (note in listA.archiveL[listA.currentArchivehNumber].noteList) print(
                "${
                    listA.archiveL[listA.currentArchivehNumber].noteList.indexOf(note)+1
                } "
            )
            println(" ")
            println("Введите номер заметки")
            var m = readln()
            if (isNumeric(m)) {
                var n = m.toInt()
                if (n <= listA.archiveL[listA.currentArchivehNumber].noteList.size && n>0) {
                    println("Выбрана заметка № ${n} :")
                    println(" ' ${listA.archiveL[listA.currentArchivehNumber].noteList[n-1]} ' ")

                    println("Для продолжения нажмите любую клавишу")
                    val resumeProg = readln()
                    noteMenu(lstMenu,listA)

                } else {
                    println("Номер заметки должен быть больше нуля и не должен превышать ${listA.archiveL[listA.currentArchivehNumber].noteList.size}")
                    choiceNote(lstMenu,listA)
                }
            } else {
                println("Введите число !!!")
                choiceNote(lstMenu,listA)
            }
        }else{
            println("список заметок пуст, выбор невозможен ")
            noteMenu(lstMenu,listA)

        }
    }

    fun exitProg() {
        println("Вы вышли из программы")
    }

    fun choiceArchive(lstMenu:List<String>,listA: ArchiveList) {
        print("Список архивов: ")
        if(listA.archiveL.isNotEmpty()) {
            for (arch in listA.archiveL) print("${arch.number} ")
            println(" ")
            println("Введите номер архива")
            var m = readln()
            if (isNumeric(m)) {
                var n = m.toInt()
                if (n <= listA.archiveL.size && n>0) {
                    println("Выбран архив № $n")
                    //-------------Выводим список заметок-------------------------------
                    listA.currentArchivehNumber=n-1
                    noteMenu(lstMenu,listA)
                } else {
                    println("Номер архива должен быть больше нуля и не превышать ${listA.archiveL.size}")
                    choiceArchive(lstMenu,listA)
                }
            } else {
                println("Введите число !!!")
                choiceArchive(lstMenu,listA)
            }

        } else {
            println("список архивов пуст, выбор невозможен ")
            universalMenu(lstMenu,listA)
        }

    }

    fun createArchive(lstMenu:List<String>,listA: ArchiveList) {
        val nList: MutableList<String> = mutableListOf()
        val newArch:Archive=Archive(++listA.archiveNum, nList)
        listA.archiveL.add(newArch)
        println("Новый архив создан")
        universalMenu(lstMenu,listA)
    }


    fun isNumeric(toCheck: String): Boolean {
        return toCheck.all { char -> char.isDigit() }
    }



}