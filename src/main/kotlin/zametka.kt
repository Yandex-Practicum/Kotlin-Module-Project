import java.util.Scanner

class Zametka(

    val name: String,
    val textZametka: String
)

class spisZmt {

    val zamArrayList: MutableList<String> = ArrayList()

    fun dodZamet(

    ) {
        zamArrayList.add(Scanner(System.`in`).toString())
    }

}



class zametkaVvod {

    fun newZam() {
        println("Ввведите название заметки")
        Scanner(System.`in`)
        //return scanner.next()
    }
    fun vvodText() {
        println("Введите текс заметки")
        Scanner(System.`in`)
        //return scanner.next()
    }
    fun vvodZam() {
        println("Текст заметки")
        //зпринт номера массива с заметками

    }

}



fun makeZmtka(

) {
    println("Список заметок:")
    println("3. Создать заметку")
    println("4. Уже созданная заметка")
    println("5. Выход в меню Архивов")
    println("Выберите пункт меню")


}