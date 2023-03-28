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
        println("Выберете заметку или создайте новую в Архиве")

        makeZmtka()

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
            println("Выберите архив или напишите 'Выход' для выхода в Меню архивов")
            val vivArhi = Scanner(System.`in`).nextLine()

            if (vivArhi.equals("Выход", ignoreCase = true)) makeArive()
            else if (!newarhiv.containsKey(vivArhi)) {
                println("Введите правильное название архива")
                spisokArhiv().nachalo()
            }
            else {
                thisArhiv = newarhiv.keys.elementAt(0)
                makeZmtka()
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