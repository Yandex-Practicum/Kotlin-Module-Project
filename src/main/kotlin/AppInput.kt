import java.util.Scanner

object AppInput {
    fun stringInput(scanner: Scanner): String {
        var innerIntValue: String = String()
        var mark = true
        while (mark) {
            var str = scanner.nextLine()
            if (str.isNotBlank()) {
                mark = false
                innerIntValue = str
            } else {
                println("ввод не должен состоять из: символа пробела, либо пустой строки....ахтУнг!!!")
            }
        }
        return innerIntValue
    }

    fun integerInput(scanner: Scanner, menuSize: Int): Int {
        val innerIntValue: Int = 5_555_555_55
        val exit = "выход"
        var mark = true
        while (mark) {
            var str = scanner.nextLine()
            if (str.equals(exit).not()) {
                if (str.isNotBlank()) {
                    for (value in 0..menuSize) {
                        if (str.equals(value.toString())) {
                            mark = false
                            var innerSerchCount = value
                            return innerSerchCount
                        } else if (value == menuSize) {
                            println("...нужно вводить корректный данные(номер или строка) для дальнейшей работы с программой!!!")
                        }
                    }
                } else {
                    println("ввод не должен состоять из: символа пробела, либо пустой строки....ахтУнг!!!")
                }
            } else {
                mark = false
            }
        }
        return innerIntValue
    }
}

