import java.util.Scanner


class zametkaVvod : Empty<Any?>() {

    override fun nachalo() {

        println("Введите название Заметки")
        val zamVvod = Scanner(System.`in`).nextLine()
        println("Введите текст заметки:")
        val textZametki = Scanner(System.`in`).nextLine()

        println("Заметка создана")
        newarhiv[thisArhiv]?.set(zamVvod, textZametki)
        println("Выберете заметку для просмотра или создайте новую")
        makeZmtka()
    }


}

class spisokZamet : Empty<Any?>() {

    override fun nachalo() {
/*
        if (newarhiv[thisArhiv].isEmpty()) {
            println("Список архивов пустой, Вас вернет в предыдущее меню")
            makeArive()
        } else { */
            println("Список созданных заметок в архиве:")
            println(newarhiv[thisArhiv].toString())
            println("Выберите Заметку для просмотра или напишите 'Выход' для выхода в Меню заметок")
            val vivZam = Scanner(System.`in`).nextLine()

            if (vivZam.equals("Выход", ignoreCase = true)) makeZmtka()
            else if (newarhiv[thisArhiv]?.containsKey(vivZam) == true) {
                println("Текст заметки:")
                println(newarhiv[thisArhiv])
                println("Введите любой символ для выхода в Меню заметок")
                Scanner(System.`in`).nextLine()
                        makeZmtka()
            }
            else {
                println("Введите правильное название заметки")
                vivZam
            }
        }


}



fun makeZmtka(

) {
    println("Меню заметок:")
    println("3. Создать заметку")
    println("4. Уже созданная заметка")
    println("5. Выход в меню Архивов")
    println("Выберите пункт меню")

}
