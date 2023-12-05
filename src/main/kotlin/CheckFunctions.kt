
    fun checkName(namesInList: List<String>): String {
        while (true) {
            val userInput = readln()
            if (userInput.isBlank()) {
                println("Имя не может быть пустым")
            } else if (namesInList.contains(userInput)) {
                println("Элемент с таким именем уже есть")
            } else return userInput
        }
    }
    fun checkUserInput(sizeOfList: Int): Int {
        while (true) {
            println("Введите команду")
            val userInput = readln().toIntOrNull()
            if ((userInput == null)) {
                println("Вы ввели не число, попробуйте снова")
            } else if ((userInput < 0) or (userInput > sizeOfList + 1)) {
                println("Данное число вне диапазона")
            } else return userInput
        }
    }
