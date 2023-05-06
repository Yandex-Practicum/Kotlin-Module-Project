class Menu {
    fun screen(filename1: String): Boolean {
        println("Вы находитесь в ${if (filename1 == "/src/main/kotlin") "исходной директории" else "архиве '${currentFolder(filename1)}'"}")
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
        var line = readln().toIntOrNull()
        while (line !in 1..5) {
            println("Пожалуйста, выберите одну из предоставленных опций. Введите только цифру опции без других символов")
            line = readln().toIntOrNull()
        }
        when (line) {
            1 -> create(filename1, true)
            2 -> create(filename1, false)
            3 -> select(filename1, true)
            4 -> select(filename1, false)
            5 -> {
                if (filename1 == "/src/main/kotlin") {
                    return false
                }
            }
        }
        return true
    }

    private fun select(filename1: String, isNote: Boolean) {
        var line: String
        val altPrint = if (isNote) {
            "заметки"
        } else {
            "архива"
        }
        println("Содержание ${if (filename1 == "/src/main/kotlin") "исходной директории" else "архива '${currentFolder(filename1)}'"}:")
        search("NoMatter", filename1, isNote, SearchType.SEARCH)
        if (search("NoMatter", filename1, isNote, SearchType.IF_EMPTY)) {
            println("Пожалуйста, выберите одну из предоставленных опций. Впишите название $altPrint")
            line = readln()
            while (!search(line, filename1, isNote, SearchType.CHECK)) {
                println("Название $altPrint не было введено корректно. Попробуйте снова")
                line = readln()
            }
            if (isNote) {
                readTxt(line, filename1)
            } else {
                screen(selectArchive(line, filename1))
            }

        } else {
            if (filename1 == "/src/main/kotlin") {
                println("В этой директории нет ${if (isNote) "заметок. Проверьте архивы." else "архивов."}")
                println()
            } else {
                println("В архиве '${currentFolder(filename1)}' отсутсвуют ${if (isNote) altPrint else "архивы"}. Чтобы их выбрать, их нужно сначала создать.")
                println()
            }
        }
    }

    private fun create(filename1: String, isNote: Boolean) {
        var line: Int?
        var title: String
        var altPrint = if (isNote) {
            "заметки"
        } else {
            "архива"
        }
        var texxt: String
        println("Введите название $altPrint")
        title = readln()
        while (search(title, filename1, isNote, SearchType.CHECK) || title == "") {
            if (title == "") {
                println("Название $altPrint не может быть пустым, попробуйте снова")
            } else {
                println("${if (isNote) "Заметка" else "Архив"} с данным названием уже существует. Попробуйте снова.")
            }
            title = readln()
        }
        if (isNote) {
            altPrint = "Введите текст заметки"
            println(altPrint)
            texxt = readln()
            while (true) {
                println("Пожалуйста, выберите опцию из предоставленных ниже")
                println("1. Завершить создание заметки")
                println("2. Продолжить текст с нового абзаца")

                line = readln().toIntOrNull()
                while (line !in 1..2) {
                    println("Пожалуйста, выберите одну из предоставленных опций. Введите только цифру опции без других символов")
                    line = readln().toIntOrNull()
                }

                if (line == 1) {
                    break
                } else {
                    println(altPrint)
                    texxt = texxt + """|
                        |""".trimMargin() + readln()
                }
            }
            createTxt(title, texxt, filename1)
        } else {
            createArchive(title, filename1)
            println("Архив создан")
            screen(selectArchive(title, filename1))
        }

    }
}

fun currentFolder(filename1: String): String {
    var array = filename1.toCharArray()
    var result = ""
    var truth = true
    for (i in array.indices.reversed()) { // итерируемся по массиву в обратном направлении
        if (array[i] == '/') {
            truth = false
        }
        if (truth) {
            result += array[i]
        }
    }
    array = result.toCharArray()
    result = ""
    for (i in array.indices.reversed()) { // итерируемся по массиву в обратном направлении
        result += array[i]
    }
    return result
}
