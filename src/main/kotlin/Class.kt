import java.util.Scanner
open class Note()  {
    var name: String = ""
    var text : String = ""
}
open class Archive(){
    var name : String = ""
    var notes: MutableList<Note> = mutableListOf()
}



open class DataBaze : GeneralScreen,Input,createNew,select,Go, readNote {
    var ArchivesList: MutableList<Archive> = mutableListOf()
    val scanner = Scanner(System.`in`)
    open fun <T> PrintList(obj: T) {
        var number = 0
        when (obj) {
            is DataBaze ->
            {println("Список архивов:")
                for (archiveTemp in obj.ArchivesList) {
                    number++
                    println(" $number ) " + archiveTemp.name)
                }
                println(" ${++number} ) Назад")
            }
            is Archive ->
            {println("Список заметок:")
                for (noteTemp in obj.notes) {
                    number++
                    println(" $number ) " + noteTemp.name)
                }
                println(" ${++number} ) Назад")
            }
        }
    }

    override fun <T> toGeneralScreen(obj: T) {
        var text: Array<String> = arrayOf("архивов", "архив", "мой уже созданный архив", "Выход")
        if (!(obj is DataBaze)) text =
            arrayOf("заметок", "замету", "моя уже созданная заметка", "Назад")
        println(
            "Меню ${text[0]}:\n" +
                    "1. Создать ${text[1]}\n" +
                    "2. Это ${text[2]}\n" +
                    "3. ${text[3]} "
        )
        toGo(obj, toInput(obj, 3))
    }

    override fun <T> toInput(obj: T, MaxChoose: Int): Int {
        while (true) {
            println()
            println("Введите номер пункта меню:")
            val number = scanner.nextLine().toIntOrNull()
            if (number == null) {
                println("Введите число.")
            } else if (number < 1 || number > MaxChoose) {
                println("Введите число от 1 до $MaxChoose")
            } else return number
        }
    }
    override fun <T> toCreateNew(obj: T) {
        if (obj is DataBaze) {
            println("Введите название архива:")
            val nameInput = scanner.nextLine()
            if (nameInput.isNotBlank()) {
                val newArchive = Archive().apply { name = nameInput }
                obj.ArchivesList.add(newArchive)
                println("Архив '$nameInput' успешно создан!")
            } else {
                println("Ошибка")
            }
        }

        else if (obj is Archive) {
            val newNote = Note()
            println("Введите название заметки:")
            val nameInput = scanner.nextLine()
            if (nameInput.isNotBlank()) {
                newNote.name = nameInput
            } else {
                println("Ошибка. Отсутствует текст")
                toGeneralScreen(obj)



            }
            println("Введите текст заметки:")
            val textInput = scanner.nextLine()
            if (textInput.isNotBlank()) {
                newNote.text = textInput
            } else {
                println("Ошибка Отсутствует текст")
                toGeneralScreen(obj)
            }
            obj.notes.add(newNote)
            println("Заметка '${newNote.name}' добавлена в архив")
        }
        toGeneralScreen(obj)
    }

    override fun <T> toSelect(obj: T) {
        PrintList(obj)
        when (obj) {
            is DataBaze -> {
                if (obj.ArchivesList.size!=0)
                {
                    val num = toInput(obj, obj.ArchivesList.size+1).toInt()
                    if (num==obj.ArchivesList.size+1) toGeneralScreen(obj)
                    else toGeneralScreen(obj.ArchivesList[num-1])}

                else {
                    println("Список пуст")
                    toGeneralScreen(obj)
                }
            }

            is Archive -> {
                if (obj.notes.size!=0) {
                    val num = toInput(obj, obj.notes.size+1).toInt()
                    if (num==obj.notes.size+1) toGeneralScreen(obj)
                    else toReadNote(obj.notes[num - 1],obj)
                }
                else {
                    println("Список пуст")
                    toGeneralScreen(obj)
                }
            }
        }

    }

    override fun <T> toReadNote(obj: T, actualArchive:Archive) {
        println("---------------------------------------")
        when (obj) {
            is Note -> {
                println("Название заметки: " + obj.name)
                println("Текст заметки:" + obj.text)
                println("---------------------------------------")
                println("Нажмите любую клавишу для возврата")
                val nameInput = scanner.nextLine()
                //toGeneralScreen(actualArchive)
                toSelect(actualArchive)

            }
        }
    }

    override fun <T> toGo(obj: T, number: Int) {
        when (number) {
            1 -> toCreateNew(obj)
            2 -> toSelect(obj)
            3 -> {
                when (obj) {
                    is DataBaze -> {
                        println("Выполнен выход из программы")
                        System.exit(0)}
                    is Archive ->      toSelect(this)
                }
            }
            else ->  println("Ошибка. Введите номер команды")
        }
    }
}