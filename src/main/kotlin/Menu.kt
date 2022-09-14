class Menu {

    fun archiveMenu(listA:ArchiveList) {
        print("Список архивов: ")
        if(listA.archiveL.isNotEmpty()) {
            for (arch in listA.archiveL) print("${arch.number} ")
        } else println("пуст")
        println(" ")
        println("0. Создать новый архив")
        println("1. Выбрать архив")
        println("2. Выход")

        var i = readln()
        if (isNumeric(i)) {
            var j = i.toInt()
            if(j in 0..2) archiveAction(j,listA) else {
                println("Введите число от 0 до 2 !")
                archiveMenu(listA)
            }
        } else {
            println("Введите число !!!")
            archiveMenu(listA)
        }

    }

    fun noteMenu(archN:Int,listA:ArchiveList) {
        listA.currentArchivehNumber = archN
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
        var z = readln()
        if (isNumeric(z)) {
            var k = z.toInt()
            if(k in 0..2) noteAction(k, listA) else {
                println("Введите число от 0 до 2 !")
                noteMenu(listA.currentArchivehNumber,listA)
            }
        } else {
            println("Введите число !!!")
            noteMenu(listA.currentArchivehNumber,listA)
        }
    }

    fun noteAction(choice: Int,listA: ArchiveList){
        when (choice) {
            0 -> createNote(listA)
            1 -> choiceNote(listA)
            2 -> archiveMenu(listA)
        }
    }

    fun archiveAction(choice: Int, listA: ArchiveList) {
        when (choice) {
            0 -> createArchive(listA)
            1 -> choiceArchive(listA)
            2 -> exitProg()
        }

    }

    fun createNote(listA: ArchiveList) {
        println("Введите текст заметки")
        val txtNote = readln()
        listA.archiveL[listA.currentArchivehNumber].noteList.add(txtNote)
        println("Ваша заметка создана и добавлена в архив № ${listA.currentArchivehNumber+1}")
        noteMenu(listA.currentArchivehNumber, listA)
    }

    fun choiceNote(listA: ArchiveList) {
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
                    noteMenu(listA.currentArchivehNumber,listA)

                } else {
                    println("Номер заметки должен быть больше нуля и не должен превышать ${listA.archiveL[listA.currentArchivehNumber].noteList.size}")
                    choiceNote(listA)
                }
            } else {
                println("Введите число !!!")
                choiceNote(listA)
            }
        }else{
            println("список заметок пуст, выбор невозможен ")
            noteMenu(listA.currentArchivehNumber, listA)

        }
    }

    fun exitProg() {
        println("Вы вышли из программы")
    }

    fun choiceArchive(listA: ArchiveList) {
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
                    noteMenu(n-1,listA)
                } else {
                    println("Номер архива должен быть больше нуля и не превышать ${listA.archiveL.size}")
                    choiceArchive(listA)
                }
            } else {
                println("Введите число !!!")
                choiceArchive(listA)
            }

        } else {
            println("список архивов пуст, выбор невозможен ")
            archiveMenu(listA)
        }

    }

    fun createArchive(listA: ArchiveList) {
        val nList: MutableList<String> = mutableListOf()
        val newArch:Archive=Archive(++listA.archiveNum, nList)
        listA.archiveL.add(newArch)
        println("Новый архив создан")
        archiveMenu(listA)
    }


    fun isNumeric(toCheck: String): Boolean {
        return toCheck.all { char -> char.isDigit() }
    }



}