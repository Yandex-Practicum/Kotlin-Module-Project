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



fun makeZmtka(

) {
    println("Меню заметок:")
    println("3. Создать заметку")
    println("4. Уже созданная заметка")
    println("5. Выход в меню Архивов")
    println("Выберите пункт меню")

}
