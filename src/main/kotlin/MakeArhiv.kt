import java.util.Scanner



class inArhive: Empty<Any?>() {

    override fun nachalo() {

        println("Введите название Архива")
        val arhivVvod = Scanner(System.`in`).nextLine()
        if (newarhiv.containsKey(arhivVvod)) {
            println("Архив с таким именем уже существует.")
            return
        }

        newarhiv[arhivVvod] = mutableMapOf()
        println("Архив создан")
        thisArhiv = arhivVvod

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



