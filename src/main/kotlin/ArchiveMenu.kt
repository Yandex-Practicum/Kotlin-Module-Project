import java.util.Scanner

class ArchiveMenu {

    var archiveList: MutableList<Archive> = ArrayList()
    var archiveNum:Int = 0
    var currentArcivehNumber:Int = 0

    fun archiveMenu() {
        print("Список архивов: ")
        if(archiveList.isNotEmpty()) {
            for (arch in archiveList) print("${arch.number} ")
            } else println("пуст")
        println(" ")
        println("0. Создать новый архив")
        println("1. Выбрать архив")
        println("2. Выход")

        var i = readln()
        if (isNumeric(i)) {
            var j = i.toInt()
            if(j in 0..2) archiveAction(j) else {
                println("Введите число от 0 до 2 !")
                archiveMenu()
            }
        } else {
            println("Введите число !!!")
            archiveMenu()
        }

    }

    fun noteMenu(archN:Int) {
        currentArcivehNumber = archN
        print("Список заметок: ")
        if (archiveList[archN].noteList.isNotEmpty()) {
            for (note in archiveList[archN].noteList) print(
                "${
                    archiveList[archN].noteList.indexOf(
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
            if(k in 0..2) noteAction(k) else {
                println("Введите число от 0 до 2 !")
                noteMenu(currentArcivehNumber)
            }
        } else {
            println("Введите число !!!")
            noteMenu(currentArcivehNumber)
        }
    }

    fun archiveAction(choice: Int) {
           when (choice) {
                0 -> createArchive()
                1 -> choiceArchive()
                2 -> exitProg()
            }

    }


    fun noteAction(choice: Int){
        when (choice) {
                0 -> createNote()
                1 -> choiceNote()
                2 -> archiveMenu()
                }
    }

    fun createNote() {
        println("Введите текст заметки")
        val txtNote = readln()
        archiveList[currentArcivehNumber].noteList.add(txtNote)
        println("Ваша заметка создана и добавлена в архив № ${currentArcivehNumber+1}")
        noteMenu(currentArcivehNumber)
    }

    fun choiceNote() {
        print("Список заметок: ")
        if (archiveList[currentArcivehNumber].noteList.isNotEmpty()) {
            for (note in archiveList[currentArcivehNumber].noteList) print(
                "${
                    archiveList[currentArcivehNumber].noteList.indexOf(note)+1
                } "
            )
            println(" ")
            println("Введите номер заметки")
            var m = readln()
            if (isNumeric(m)) {
                var n = m.toInt()
                if (n <= archiveList[currentArcivehNumber].noteList.size && n>0) {
                    println("Выбрана заметка № ${n} :")
                    println(" ' ${archiveList[currentArcivehNumber].noteList[n-1]} ' ")

                    println("Для продолжения нажмите любую клавишу")
                    val resumeProg = readln()
                    noteMenu(currentArcivehNumber)

                } else {
                    println("Номер заметки должен быть больше нуля и не должен превышать ${archiveList[currentArcivehNumber].noteList.size}")
                    choiceNote()
                }
            } else {
                println("Введите число !!!")
                choiceNote()
                    }
        }else{
            println("список заметок пуст, выбор невозможен ")
            noteMenu(currentArcivehNumber)

        }
    }

    fun exitProg() {
        println("Вы вышли из программы")
    }

    fun choiceArchive() {
        print("Список архивов: ")
        if(archiveList.isNotEmpty()) {
            for (arch in archiveList) print("${arch.number} ")
            println(" ")
            println("Введите номер архива")
            var m = readln()
            if (isNumeric(m)) {
                var n = m.toInt()
                if (n <= archiveList.size && n>0) {
                    println("Выбран архив № $n")
                    //-------------Выводим список заметок-------------------------------
                    noteMenu(n-1)
                } else {
                    println("Номер архива должен быть больше нуля и не превышать ${archiveList.size}")
                    choiceArchive()
                }
            } else {
                println("Введите число !!!")
                choiceArchive()
            }

        } else {
            println("список архивов пуст, выбор невозможен ")
            archiveMenu()
        }

    }

    fun createArchive() {
        val nList: MutableList<String> = mutableListOf()
        val newArch:Archive=Archive(++archiveNum, nList)
        archiveList.add(newArch)
        println("Новый архив создан")
        archiveMenu()
    }

    fun isNumeric(toCheck: String): Boolean {
        return toCheck.all { char -> char.isDigit() }
    }
}