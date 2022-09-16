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
        "2. К списку архивов"
    )
    val choiceArchiveList = listOf("архивов","архива")
    val choiceNoteList = listOf("заметок","заметки")

    val inputChecking = InputCheck()

    fun universalMenu(lstMenu:List<String>,listA:ArchiveList){
        print(lstMenu[0])
        listPrint(lstMenu,listA)
        for(i in 2..lstMenu.size-1)
            println(lstMenu[i])

        printMenuItem(lstMenu,listA,::universalAction)
    }

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

    fun universalAction(lstMenu:List<String>, choice: Int, listA: ArchiveList){
        var isNote = false
        if(lstMenu[0]=="Список заметок: ") isNote=true
        when (choice) {
            0 -> {if (isNote) createNote(listA) else createArchive(listA)}
            1 -> {if (isNote) choiceUniversal(choiceNoteList,listA) else choiceUniversal(choiceArchiveList,listA)}
            2 -> {if (isNote) universalMenu(arhiveMenuList,listA) else exitProg()}
        }
    }

    fun printMenuItem(lstMenu:List<String>, listA:ArchiveList, actFun: (List<String>, Int, ArchiveList) -> Unit){

        val j = inputChecking.inputAndCheck()
        if (j!=-1) {
                if(j in 0..2) actFun(lstMenu,j,listA) else {
                println("Введите число от 0 до 2 !")
                universalMenu(lstMenu, listA)
            }
        } else {
            println("Введите число !!!")
            universalMenu(lstMenu, listA)
        }
    }

     fun createNote(listA: ArchiveList) {
        println("Введите текст заметки")
        val txtNote = readln()
        listA.archiveL[listA.currentArchivehNumber].noteList.add(txtNote)
        println("Ваша заметка создана и добавлена в архив № ${listA.currentArchivehNumber+1}")
        universalMenu(noteMenuList,listA)
    }

    fun printNotesList(listA:ArchiveList):Boolean {

        if (listA.archiveL[listA.currentArchivehNumber].noteList.isNotEmpty()) {
            for (note in listA.archiveL[listA.currentArchivehNumber].noteList) print(
                "${
                    listA.archiveL[listA.currentArchivehNumber].noteList.indexOf(note)+1
                } "
            )
            return true
        }
        return false
    }

    fun showNote(n:Int,listA:ArchiveList){
        if (n <= listA.archiveL[listA.currentArchivehNumber].noteList.size && n>0) {
            println("Выбрана заметка № ${n} :")
            println(" ' ${listA.archiveL[listA.currentArchivehNumber].noteList[n-1]} ' ")

            println("Для продолжения нажмите любую клавишу")
            val resumeProg = readln()
            universalMenu(noteMenuList,listA)

        } else {
            println("Номер заметки должен быть больше нуля и не должен превышать ${listA.archiveL[listA.currentArchivehNumber].noteList.size}")
            choiceUniversal(choiceNoteList,listA)
        }
    }

    fun exitProg() {
        println("Вы вышли из программы")
    }

    fun printArchiveList(listA:ArchiveList):Boolean {

        if(listA.archiveL.isNotEmpty()) {
            for (arch in listA.archiveL) print("${arch.number} ")
            return true
        }
        return false
    }

    fun showArchive(n:Int,listA:ArchiveList){
        if (n <= listA.archiveL.size && n>0) {
            println("Выбран архив № $n")
            //-------------Выводим список заметок-------------------------------
            listA.currentArchivehNumber=n-1
            universalMenu(noteMenuList, listA)
        } else {
            println("Номер архива должен быть больше нуля и не превышать ${listA.archiveL.size}")
            choiceUniversal(choiceArchiveList,listA)
        }

    }

    fun choiceF(lst:List<String>,listA:ArchiveList,printFun: (ArchiveList) -> Boolean, showF: (Int, ArchiveList) -> Unit){
        if (printFun(listA)) {
            println(" ")
            println("Введите номер ${lst[1]}")
            val n = inputChecking.inputAndCheck()
            if (n != -1) showF(n, listA)
            else {
                println("Введите число !!!")
                choiceUniversal(lst, listA)
            }

        } else {
            println("список ${lst[0]} пуст, выбор невозможен ")
            universalMenu(arhiveMenuList, listA)
        }
    }

    fun choiceUniversal(lst:List<String>,listA: ArchiveList) {
        print("Список ${lst[0]}: ")
        when(lst[0]){
            "архивов"-> choiceF(lst,listA,::printArchiveList,::showArchive)
            "заметок"-> choiceF(lst,listA,::printNotesList,::showNote)
        }
    }

    fun createArchive(listA: ArchiveList) {
        val nList: MutableList<String> = mutableListOf()
        val newArch=Archive(++listA.archiveNum, nList)
        listA.archiveL.add(newArch)
        println("Новый архив создан")
        universalMenu(arhiveMenuList,listA)
    }

}