
fun main(args: Array<String>) {
    var line: String
    var keepGoing = true
// /src/main/kotlin
    while (keepGoing){
        println("Вы находитесь в исходной директории")
        println()
        println("Пожалуйста, выберите опцию из предоставленных ниже")
        println("1. Выбрать заметку")
        println("2. Создать заметку")
        println("3. Завершить выполнение программы")
        println("(Для выбора опции введите номер)")

        line = readln()
        while(line != "1" && line != "2" && line != "3") {
            println("Пожалуйста, выберите одну из предоставленных опций. Введите только цифру опции без других символов")
            line = readln()
        }

        if (line == "2"){
            creation("/src/main/kotlin")
        } else if (line == "1") {
            selection("/src/main/kotlin")
        }else if(line == "3"){
        keepGoing = false
        }
    }
}

fun selection(filename1: String) {
    var line: String
    if (searchIfEmpty(filename1, true) || searchIfEmpty(filename1, false)) {
        println("Пожалуйста, выберите опцию из предоставленных ниже")
        println("1. Выбрать заметку")
        println("2. Выбрать архив для заметки")
        println("3. Вернутся в главное меню")
        line = readln()
        while (line != "1" && line != "2" && line != "3") {
            println("Пожалуйста, выберите одну из предоставленных опций. Введите только цифру опции без других символов")
            line = readln()
        }
        if(filename1=="/src/main/kotlin"){
            println("Содержание исходной директории.")
        }else{
            println("Содержание архива '${currentFolder(filename1)}'")
        }
        search(filename1)
        if (line == "1") {
            if (searchIfEmpty(filename1, true)) {
                println("Пожалуйста, выберите одну из предоставленных опций. Впишите название заметки")
                var noteTitle = readln()
                if (searchCheck(noteTitle, filename1, true)) {
                    readTxt(noteTitle, filename1)
                } else {
                    while (!searchCheck(noteTitle, filename1, true)) {
                        println("Название заметки не было введено корректно. Попробуйте снова")
                        noteTitle = readln()
                    }
                    readTxt(noteTitle, filename1)
                }
            } else {
                if(filename1=="/src/main/kotlin"){
                    println("В этой директории нет заметок. Проверьте архивы")
                    println()
                }else{
                    println("В архиве '${currentFolder(filename1)}'' отсутсвуют заметки. Чтобы их выбрать, их нужно сначала создать")
                    println()
                }
            }
        } else if (line == "2") {
            if (searchIfEmpty(filename1, false)) {
                println("Пожалуйста, выберите одну из предоставленных опций. Впишите название архива")
                line = readln()
                if (searchCheck(line, filename1, false)) {
                    val filename = selectArchive(line, filename1)
                    selection(filename)
                } else {
                    while (!searchCheck(line, filename1, false)) {
                        println("Название архива не было введено корректно. Попробуйте снова")
                        line = readln()
                    }
                    val filename = selectArchive(line, filename1)
                    selection(filename)
                }
            }
        }
    }else {
        if(filename1=="/src/main/kotlin"){
            println("Заметок пока нет. Создайте заметку, если хотите её выбрать")
            println()
        }else{
            println("В архиве '${currentFolder(filename1)}' отсутсвуют заметки или архивы. Тут выбирать пока нечего")
            println()
        }
    }
}
fun creation (filename1: String) {
    println("Пожалуйста, выберите опцию из предоставленных ниже")
    println("1. Создать заметку")
    println("2. Создать архив для заметки")
    println("3. Выбрать архив для создания заметки")
    println("4. Вернутся в главное меню")

    var textt: String
    var title: String
    var line = readln()
    while (line != "1" && line != "2" && line != "3" && line != "4"){
        println("Пожалуйста, выберите одну из предоставленных опций. Введите только цифру опции без других символов")
        line = readln()
    }

    if (line == "1") {
        println("Введите название заметки")
        title = readln()
        if (title == ""){
            while (title == ""){
                println("Название заметки не может быть пустым, попробуйте снова")
                title = readln()
            }
        }else if(searchCheck(title, filename1, true)){
            while (searchCheck(title, filename1, true)){
                println("Заметка с данным названием уже существует. Попробуйте снова.")
                title = readln()
            }
        }
        println("Введите текст заметки")
        textt = readln()

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
                textt = textt + """|
                        |""".trimMargin() + readln()
            }
        }

        createTxt(title, textt, filename1)
    } else if (line == "2") {
        println("Введите название архива")
        title = readln()
        if (title == ""){
            while (title == ""){
                println("Название архива не может быть пустым, попробуйте снова")
                title = readln()
            }
        }else if(searchCheck(title, filename1, false)){
            while (searchCheck(title, filename1, false)){
                println("Архив с данным названием уже существует. Попробуйте снова.")
                title = readln()
            }
        }
        createArchive(title, filename1)
        println("Архив создан")
        println("Вы находитесь в архиве $title")
        creation(selectArchive(title,filename1))
    }else if (line== "3"){
            if(filename1=="/src/main/kotlin"){
                println("Содержание исходной директории.")
            }else{
                println("Содержание архива '${currentFolder(filename1)}'")
            }
            search(filename1)
            println("Выберите архив из представленных выше")
            line = readln()
            println("Вы перешли в архив $line")
            creation(selectArchive(line,filename1))
        }else{
            if(filename1=="/src/main/kotlin"){
                println("Архивы отсутствуют")
                println()
            }else{
                println("В архиве '${currentFolder(filename1)}' нет архивов")
                println()
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