import java.util.Scanner


class inArhive : Empty<Any?>() {

    override fun nachalo() {

        println("Введите название Архива")
        val arhivVvod = Scanner(System.`in`).nextLine()
        if (newarhiv.containsKey(arhivVvod)) {
            println("Архив с таким именем уже существует, возвращение в меню Архивов")
            makeArive()
        }

        newarhiv[arhivVvod] = mutableMapOf()
        println("Архив создан")
        thisArhiv = arhivVvod
        //println("Выберете заметку или создайте новую в Архиве")

        makeArive()

    }
}

class spisokArhiv : Empty<Any?>() {

    override fun nachalo() {

        if (newarhiv.isEmpty()) {
            println("Список архивов пустой, Вас вернет в предыдущее меню")
            makeArive()
        } else {
            println("Список созданных архивов:")
            for ((index, archive) in newarhiv.keys.withIndex()) {
                println("${index + 1}. $archive")
            }
            println("Выберите номер архива")


            val dlina: Int = newarhiv.size

            if (scanner.hasNextInt()) {
                val vivArhi = scanner.nextInt()

                if (vivArhi in 0..dlina) {
                    thisArhiv = newarhiv.keys.elementAt(vivArhi - 1)
                    makeZmtka() } else
                    {
                        println("Введите номер архива который хотите выбрать, вас вернет в список архивов")
                        spisokArhiv().nachalo()
                    }

            }  else {
            println("Введите номер архива который хотите выбрать, вас вернет в список архивов")
                scanner.next()
                spisokArhiv().nachalo()
            }
    }
}
}



fun makeArive(

) {
    println("Меню архивов:")
    println("0. Создать архив")
    println("1. Уже созданный архив")
    println("2. Выход из программы")
    println("Выберите пункт меню")
    Logika()
}