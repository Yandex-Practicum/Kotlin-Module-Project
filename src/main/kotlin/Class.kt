class Menu {
    fun screen(filename1: String): Boolean {
        var line: String
        if (filename1 == "/src/main/kotlin") {
            println("Вы находитесь в исходной директории")
        } else {
            println("Вы находитесь в архиве '${currentFolder(filename1)}'")
        }
        println("Выберите опцию:")
        println("1. Создать заметку")
        println("2. Создать архив")
        println("3. Выбрать заметку")
        println("4. Выбрать архив")
        if (filename1 == "/src/main/kotlin") {
            println("5. Завершить выполнение программы")
        } else {
            println("5. Вернуться в исходную директорию")
        }
        line = readln()
        while (line != "1" && line != "2" && line != "3" && line != "4" && line != "5") {
            println("Пожалуйста, выберите одну из предоставленных опций. Введите только цифру опции без других символов")
            line = readln()
        }
        if (line == "1") {
            create(filename1, true)
        } else if (line == "2") {
            create(filename1, false)
        } else if (line == "3") {
            select(filename1, true)
        } else if (line == "4") {
            select(filename1, false)
        } else if (line == "5") {
            if (filename1 == "/src/main/kotlin") {
                return false
            }
        }
        return true
    }

    private fun select(filename1: String, isNote: Boolean) {
        var line: String
        if (filename1 == "/src/main/kotlin") {
            println("Содержание исходной директории:")
        } else {
            println("Содержание архива '${currentFolder(filename1)}':")
        }
        search("NoMatter", filename1, true, "Search")
        if (isNote) {
            if (search("NoMatter",filename1, true, "IfEmpty")) {
                println("Пожалуйста, выберите одну из предоставленных опций. Впишите название заметки")
                line = readln()
                if (search(line, filename1, true, "Check")) {
                    readTxt(line, filename1)
                } else {
                    while (!search(line, filename1, true, "Check")) {
                        println("Название заметки не было введено корректно. Попробуйте снова")
                        line = readln()
                    }
                    readTxt(line, filename1)
                }
            } else {
                if (filename1 == "/src/main/kotlin") {
                    println("В этой директории нет заметок. Проверьте архивы")
                    println()
                } else {
                    println("В архиве '${currentFolder(filename1)}' отсутсвуют заметки. Чтобы их выбрать, их нужно сначала создать")
                    println()
                }
            }
        } else {
            if (search("NoMatter",filename1, false, "IfEmpty")) {
                println("Пожалуйста, выберите одну из предоставленных опций. Впишите название архива")
                line = readln()
                if (search(line, filename1, false, "Check")) {
                    val filename = selectArchive(line, filename1)
                    screen(filename)
                } else {
                    while (!search(line, filename1, false, "Check")) {
                        println("Название архива не было введено корректно. Попробуйте снова")
                        line = readln()
                    }
                    val filename = selectArchive(line, filename1)
                    screen(filename)
                }
            }else{
                if (filename1 == "/src/main/kotlin") {
                    println("В этой директории нет архивов.")
                    println()
                } else {
                    println("В архиве '${currentFolder(filename1)}'' отсутсвуют архивы. Чтобы их выбрать, их нужно сначала создать")
                    println()
                }
            }
        }
    }

    private fun create(filename1: String, isNote: Boolean) {
        var line: String
        if (isNote) {
            var title: String
            var texxt: String
            println("Введите название заметки")
            title = readln()
            if (title == "") {
                while (title == "") {
                    println("Название заметки не может быть пустым, попробуйте снова")
                    title = readln()
                }
            } else if (search(title, filename1, true, "Check")) {
                while (search(title, filename1, true, "Check")) {
                    println("Заметка с данным названием уже существует. Попробуйте снова.")
                    title = readln()
                }
            }
            println("Введите текст заметки")
            texxt = readln()

            while (true) {
                println("Пожалуйста, выберите опцию из предоставленных ниже")
                println("1. Завершить создание заметки")
                println("2. Продолжить текст с нового абзаца")

                line = readln()
                while (line != "1" && line != "2") {
                    println("Пожалуйста, выберите одну из предоставленных опций. Введите только цифру опции без других символов")
                    line = readln()
                }

                if (line == "1") {
                    break
                } else {
                    println("Введите текст заметки")
                    texxt = texxt + """|
                        |""".trimMargin() + readln()
                }
            }

            createTxt(title, texxt, filename1)
        } else {
            println("Введите название архива")
            line = readln()
            if (line == "") {
                while (line == "") {
                    println("Название архива не может быть пустым, попробуйте снова")
                    line = readln()
                }
            } else if (search(line, filename1, false, "Check")) {
                while (search(line, filename1, false, "Check")) {
                    println("Архив с данным названием уже существует. Попробуйте снова.")
                    line = readln()
                }
            }
            createArchive(line, filename1)
            println("Архив создан")
            screen(selectArchive(line, filename1))
        }
    }
}

fun currentFolder(filename1: String): String {
    var array = filename1.toCharArray()
    var result = ""
    var truth = true
    for (i in array.indices.reversed()) { // итерируемся по массиву в обратном направлении
        if(array[i]=='/'){
            truth=false
        }
        if (truth){
            result += array[i]
        }
    }
    array=result.toCharArray()
    result=""
    for (i in array.indices.reversed()) { // итерируемся по массиву в обратном направлении
        result += array[i]
    }
    return result
}