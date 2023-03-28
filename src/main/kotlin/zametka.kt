import java.util.Scanner


class zametkaVvod : Empty<Any?>() {

    override fun nachalo() {
        //val zamek = newarhiv[thisArhiv] ?: return
        println("Введите название Заметки")
        val zamVvod = Scanner(System.`in`).nextLine()
        if (zamVvod.isEmpty()) {
            println("Вы не можете ввести пустое название")
            makeZmtka()
        } else {
            println("Введите текст заметки:")
            val textZametki = Scanner(System.`in`).nextLine()

            println("Заметка создана")
            newarhiv[thisArhiv]?.set(zamVvod, textZametki)
            println("Выберете заметку для просмотра или создайте новую")
            makeZmtka()
        }
    }


}

class spisokZamet : Empty<Any?>() {

    override fun nachalo() {
            val generalZam = newarhiv[thisArhiv] ?: return
            println("Список созданных заметок в архиве:")
        for ((index, archive) in generalZam.keys.withIndex()) {
            println("${index + 1}. $archive")
        }
            println("Введите название Заметки для просмотра или напишите 'Выход' для выхода в Меню заметок")
            val vivZam = Scanner(System.`in`).nextLine()

            if (vivZam.equals("Выход", ignoreCase = true)) makeZmtka()
            else if (newarhiv[thisArhiv]?.containsKey(vivZam) == true) {
                println("Текст заметки:")
                val zamTevoe = generalZam[vivZam].toString()
                println(zamTevoe)

                //Изменить

                println("Введите любой символ для выхода в Меню заметок")
                Scanner(System.`in`).nextLine()
                        makeZmtka()
            }
            else {
                println("Введите правильное название заметки")
                spisokZamet().nachalo()
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
