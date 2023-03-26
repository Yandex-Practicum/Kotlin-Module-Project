import java.util.Scanner



class Onearhiv {
    val name: String
    val zamList: MutableList<Zametka>

    constructor(name: String, zamList: MutableList<Zametka>) {
        this.name = name
        this.zamList = zamList
    }
}

class inArhive {


    var arhivList = mutableListOf<String>()

    fun nazvanitArhiv() {
        println("Введите название Архива")
        arhivDob()
    }

    fun arhivDob() {


        var test = arhivList.add(Scanner(System.`in`).nextLine())
        //for (i in 0...test.arhivList.size - 1) {
            //println("$i. ${test.arhivList.get(i)}")
        //}
        println("Архив создан")

    }
}

fun makeArive(

) {
    println("Список архивов:")
    println("0. Создать архив")
    println("1. Уже созданный архив")
    println("2. Выход из программы")
    println("Выберите пункт меню")
    logika()
}



